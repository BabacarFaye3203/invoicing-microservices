package com.babacar.app.services;

import com.babacar.app.dto.request.CreateInvoiceRequest;
import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.dto.responses.CurrencyResponse;
import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.entities.InvoiceProducts;
import com.babacar.app.entities.Invoices;
import com.babacar.app.mappers.InvoiceMapper;
import com.babacar.app.numbering.DocumentNumbering;
import com.babacar.app.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final DocumentNumbering documentNumbering;
    private final RestTemplate restTemplate;
    private final InvoiceMapper invoiceMapper;

    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest request) throws BadRequestException {
        Invoices invoices=new Invoices();
        invoices.setUuid(UUID.randomUUID().toString());
        invoices.setDate(LocalDate.now());
        invoices.setLanguage(request.language());
        invoices.setNote(request.note());
        invoices.setStatus(request.status());
        invoices.setCreationDate(request.creationDate());
        invoices.setIndividualCustomer(request.individualCustomer());
        this.documentNumbering.manageNumbering(invoices,request.number());

        String uuid=UUID.randomUUID().toString();
        List<InvoiceProducts> invoiceProducts= request.invoiceProducts().stream().map(

                dtos->{
                    ProductResponse response=restTemplate.getForObject(
                            "http://localhost:8086/products/{uuid}",
                            ProductResponse.class,
                            dtos.getProduct()
                    );
                    InvoiceProducts invoice=InvoiceProducts.builder()
                            .uuid(uuid)
                            .product(response.uuid())
                            .invoice(dtos.getInvoice())
                            .taxe(dtos.getTaxe())
                            .designation(response.name())
                            .discount(dtos.getDiscount())
                            .quantity(dtos.getQuantity())
                            .discountType(dtos.getDiscountType())
                            .unitPrice(response.price())
                            .totalPrice(response.price()*dtos.getQuantity())
                            .build();

                    return invoice;
                }

        ).collect(Collectors.toList());

        invoices.setInvoiceProducts(invoiceProducts);
        invoiceRepository.save(invoices);

        CurrencyResponse response =restTemplate.getForObject(
                "http://localhost:8087/api/v1/currencies/{uuid}",
                CurrencyResponse.class,
                request.currency()
        );

        if (!request.currency().equals(response.uuid())){
            throw new BadRequestException("currency does not match");
        }else{
            invoices.setCurrency(response.uuid());
            invoiceRepository.save(invoices);
        }

        return invoiceMapper.toCreateInvoiceResponse(invoices);
    }
}

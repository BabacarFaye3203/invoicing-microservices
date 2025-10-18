package com.babacar.app.services;

import com.babacar.app.dto.request.CreateInvoiceProductRequest;
import com.babacar.app.dto.responses.CreateInvoiceProductResponse;
import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.entities.InvoiceProducts;
import com.babacar.app.repositories.InvoiceProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateInvoiceProduct {
    private final InvoiceProductRepository invoiceProductRepository;
    private final RestTemplate restTemplate;

    public CreateInvoiceProductResponse createInvoiceProduct(CreateInvoiceProductRequest request){

        InvoiceProducts invoiceProducts=new InvoiceProducts();
        invoiceProducts.setUuid(UUID.randomUUID().toString());
        invoiceProducts.setDesignation(request.designation());
        invoiceProducts.setQuantity(request.quantity());
        invoiceProducts.setDiscount(request.discount());
        invoiceProducts.setDiscountType(request.discountType());
        invoiceProducts.setTaxe(request.taxe());
        invoiceProductRepository.save(invoiceProducts);

        ProductResponse response=restTemplate.getForObject(
                "http://localhost:8086/products/{uuid}",
                ProductResponse.class,
                request.product()
        );
        invoiceProducts.setProduct(response.uuid());
        invoiceProducts.setUnitPrice(response.price());
        invoiceProducts.setTotalPrice(request.quantity()*response.price());
        invoiceProductRepository.save(invoiceProducts);

        invoiceProductRepository.save(invoiceProducts);


        return new CreateInvoiceProductResponse(
                invoiceProducts.getUuid(),
                invoiceProducts.getProduct(),
                invoiceProducts.getDesignation(),
                invoiceProducts.getUnitPrice(),
                invoiceProducts.getQuantity(),
                invoiceProducts.getDiscount(),
                invoiceProducts.getTaxe(),
                invoiceProducts.getTotalPrice(),
                invoiceProducts.getDiscountType()
        );

    }
}

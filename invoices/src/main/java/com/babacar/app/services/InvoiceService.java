package com.babacar.app.services;

import com.babacar.app.dto.request.CreateInvoiceRequest;
import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.entities.Invoices;
import com.babacar.app.numbering.DocumentNumbering;
import com.babacar.app.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final DocumentNumbering documentNumbering;

    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest request) throws BadRequestException {
        Invoices invoices=new Invoices();
        invoices.setDate(LocalDate.now());
        invoices.setLanguage(request.language());
        invoices.setNote(request.note());
        invoices.setStatus(request.status());
        invoices.setCreationDate(request.creationDate());
        this.documentNumbering.manageNumbering(invoices,request.number());
        invoiceRepository.save(invoices);

        return new CreateInvoiceResponse(
                invoices.getUuid(),
                invoices.getDate(),
               invoices.getLanguage(),
               invoices.getNumber(),
                invoices.getStatus(),
               invoices.getCreationDate(),
                invoices.getNote(),
               invoices.getIndividualCustomer(),
                invoices.getEnterpriseCustomer()
        );
    }
}

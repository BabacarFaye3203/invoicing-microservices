package com.babacar.app.services;

import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.entities.Invoices;
import com.babacar.app.mappers.InvoiceMapper;
import com.babacar.app.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetInvoiceService {
    private final InvoiceMapper invoiceMapper;
    private final InvoiceRepository invoiceRepository;

    public CreateInvoiceResponse getInvoice(String uuid){

        Invoices invoices=invoiceRepository.findByUuid(uuid).orElseThrow(
                ()->new NoSuchElementException("invoice not found")
        );
        return invoiceMapper.toCreateInvoiceResponse(invoices);
    }
}

package com.babacar.app.controllers;

import com.babacar.app.dto.request.CreateInvoiceRequest;
import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.services.InvoiceService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/create")
    public CreateInvoiceResponse createInvoice(
            @RequestBody CreateInvoiceRequest request
    ) throws BadRequestException {
        return invoiceService.createInvoice(request);
    }
}

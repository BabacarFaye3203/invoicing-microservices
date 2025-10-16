package com.babacar.app.controllers;

import com.babacar.app.dto.request.CreateInvoiceProductRequest;
import com.babacar.app.dto.request.CreateInvoiceRequest;
import com.babacar.app.dto.responses.CreateInvoiceProductResponse;
import com.babacar.app.dto.responses.CreateInvoiceResponse;
import com.babacar.app.services.CreateInvoiceProduct;
import com.babacar.app.services.GetInvoiceService;
import com.babacar.app.services.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;
    private final GetInvoiceService getInvoiceService;
    private final CreateInvoiceProduct createInvoiceProduct;

    public InvoiceController(InvoiceService invoiceService, GetInvoiceService getInvoiceService, CreateInvoiceProduct createInvoiceProduct) {
        this.invoiceService = invoiceService;
        this.getInvoiceService = getInvoiceService;
        this.createInvoiceProduct = createInvoiceProduct;
    }

    @PostMapping("/create")
    public CreateInvoiceResponse createInvoice(
            @RequestBody CreateInvoiceRequest request
    ) throws BadRequestException {
        return invoiceService.createInvoice(request);
    }

    @GetMapping("{uuid}")
    @Operation(summary = "get a invoice by uuid")
    public CreateInvoiceResponse getInvoice(
            @PathVariable("uuid") String uuid){
        return getInvoiceService.getInvoice(uuid);

    }

    @PostMapping("/create-invoice-product")
    @Operation(summary = "create a invoice product")
    private CreateInvoiceProductResponse createInvoiceProduct(
            @RequestBody CreateInvoiceProductRequest request){
        return createInvoiceProduct.createInvoiceProduct(request);



    }
}

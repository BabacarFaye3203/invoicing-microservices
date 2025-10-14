package com.babacar.app.dto.request;

import com.babacar.app.entities.InvoicePayments;
import com.babacar.app.entities.InvoicePricing;
import com.babacar.app.entities.InvoiceProducts;
import com.babacar.app.entities.InvoiceServices;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateInvoiceRequest(
    LocalDate date,
    String language,
    Integer number,
    String status,
    LocalDateTime creationDate,
    String note,
    String individualCustomer,
    String enterpriseCustomer,
    List<InvoiceProducts> invoiceProducts,
    List<InvoiceServices> invoiceServices,
    InvoicePricing invoicePricing,
    List<InvoicePayments> invoicePayments

) implements Serializable {
}

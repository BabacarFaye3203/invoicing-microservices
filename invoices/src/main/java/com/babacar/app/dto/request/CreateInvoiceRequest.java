package com.babacar.app.dto.request;


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
    List<InvoiceProductDto> invoiceProducts,
    CreatePaymentRequest invoicePayments,
    String currency

) implements Serializable {
}

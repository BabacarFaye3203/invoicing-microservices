package com.babacar.app.dto.request;


import com.babacar.app.entities.InvoiceProducts;

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
    List<InvoiceProducts> invoiceProducts,
    String currency

) implements Serializable {
}

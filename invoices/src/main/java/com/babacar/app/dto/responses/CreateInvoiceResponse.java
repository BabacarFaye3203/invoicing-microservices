package com.babacar.app.dto.responses;

import com.babacar.app.entities.InvoiceProducts;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record CreateInvoiceResponse(
        String uuid,
        LocalDate date,
        String language,
        String number,
        String status,
        LocalDateTime creationDate,
        String note,
        String individualCustomer,
        String currency,
        List<InvoiceProducts> invoiceProducts

) implements Serializable {
}

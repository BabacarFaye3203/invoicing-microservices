package com.babacar.app.dto.responses;

import com.babacar.app.entities.InvoicePayments;
import com.babacar.app.entities.InvoicePricing;
import com.babacar.app.entities.InvoiceProducts;
import com.babacar.app.entities.InvoiceServices;
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
        String enterpriseCustomer

) implements Serializable {
}

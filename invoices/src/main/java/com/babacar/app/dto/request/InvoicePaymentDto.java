package com.babacar.app.dto.request;

import com.babacar.app.entities.Invoices;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

public record InvoicePaymentDto(

    LocalDate paymentDate,
    String paymentMethods,
    Double amount,
    String payment
) {
}

package com.babacar.app.dto.requests;

import java.io.Serializable;
import java.time.LocalDate;

public record CreatePaymentRequest(
        double prix,
        LocalDate date,
        String paymentMethods
) implements Serializable {
}

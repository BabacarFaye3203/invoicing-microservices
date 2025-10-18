package com.babacar.app.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

public record CreatePaymentRequest(
        double prix,
        LocalDate date,
        String paymentMethods
) implements Serializable {
}

package com.babacar.app.dto.responses;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
public record PaymentResponse(
         String uuid,
         double prix,
         String paymentMethods,
         LocalDate paymentDate
)implements Serializable {
}

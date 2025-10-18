package com.babacar.app.dto.request;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record InvoiceProductDto(
        String uuid,
        String product,
        double quantity,
        double discount,
        double taxe,
        String discountType,
        String invoice

) implements Serializable {
}

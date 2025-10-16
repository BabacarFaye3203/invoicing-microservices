package com.babacar.app.dto.responses;

import jakarta.persistence.Column;

import java.io.Serializable;

public record CreateInvoiceProductResponse(
       String uuid,
        String product,
       String designation,
       double unitPrice,
       double quantity,
       double discount,
       double taxe,
       double totalPrice,
       String discountType
) implements Serializable {
}

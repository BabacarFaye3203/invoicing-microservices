package com.babacar.app.dto.request;

import java.io.Serializable;

public record CreateInvoiceProductRequest(
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

package com.babacar.app.dto.requests;

public record CreateCurrencyRequest(
        String name,
        String description,
        boolean isActive
) {
}

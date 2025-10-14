package com.babacar.app.dto.responses;

import lombok.Builder;

@Builder
public record CurrencyResponse(
        String uuid,
        String name,
        String description,
        boolean isActive
) {
}

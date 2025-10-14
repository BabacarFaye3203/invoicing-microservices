package com.babacar.app.dto.responses;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ProductResponse(
        String uuid,
        String name,
        String description,
        double price,
        String image,
        String category,
        boolean isActive,
        double stockLevel
) implements Serializable {
}

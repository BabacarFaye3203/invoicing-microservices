package com.babacar.app.dto.requests;


import java.io.Serializable;


public record CreateProductRequest(
         String name,
         String description,
         double price,
         String image,
         String category,
         boolean isActive
)implements Serializable {
}

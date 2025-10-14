package com.babacar.app.mappers;

import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.entities.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toProductResponse(Products products) ;
}

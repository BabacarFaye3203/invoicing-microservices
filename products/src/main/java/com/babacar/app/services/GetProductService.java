package com.babacar.app.services;

import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.entities.Products;
import com.babacar.app.mappers.ProductMapper;
import com.babacar.app.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetProductService {
    private final ProductRepository productRepository;

    public ProductResponse getProduct(String uuid){
        Products products=productRepository.findByUuid(uuid).orElseThrow(
                ()->new NoSuchElementException("Product not found")
        );
        return new ProductResponse(
                products.getUuid(),
                products.getName(),
                products.getDescription(),
                products.getPrice(),
                products.getImage(),
                products.getCategory(),
                products.isActive(),
                products.getStockLevel());
    }
}

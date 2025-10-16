package com.babacar.app.validators;

import com.babacar.app.constants.ProductCategoryConstants;
import com.babacar.app.entities.Products;
import com.babacar.app.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryValidator {
    private final ProductRepository productRepository;
    public void validate(String category) {

        if (!category.contains(ProductCategoryConstants.VALID_PRODUCT_CATEGORIES)){
            throw new IllegalStateException("category is not valid");
        }
    }
}

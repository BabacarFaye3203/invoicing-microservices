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
    public String validate(String product_uuid) {
        Products products= productRepository.findByUuid(product_uuid)
                .orElseThrow(() -> new EntityNotFoundException(
                        "product no found"
                ));
        String category= products.getCategory();
        if (category.contains(ProductCategoryConstants.VALID_PRODUCT_CATEGORIES)){
            return category;
        }else {
            throw new EntityNotFoundException("product category does not exists");
        }
    }
}

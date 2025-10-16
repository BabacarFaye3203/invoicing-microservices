package com.babacar.app.services;

import com.babacar.app.dto.requests.CreateProductRequest;
import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.entities.Products;
import com.babacar.app.repositories.ProductRepository;
import com.babacar.app.validators.ProductCategoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(CreateProductRequest request) throws IOException {

        Products products = new Products();
        products.setUuid(UUID.randomUUID().toString());
        products.setCategory(request.category());
        products.setName(request.name());
        products.setPrice(request.price());
        products.setDescription(request.description());

//        Path path= Paths.get(System.getProperty("Utilisateurs.babacar"),"products_file");
//        if (!(Files.exists(path))){
//            Files.createDirectories(path);
//        }
//        Path filePath= Paths.get(System.getProperty("Utilisateurs.babacar"),"products_file"+UUID.randomUUID().toString()+".pdf");
//        Files.copy(file.getInputStream(),filePath);
//        products.setImage(filePath.toUri().toString());
        productRepository.save(products);
        products.setStockLevel(products.getStockLevel()+1);
        productRepository.save(products);

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

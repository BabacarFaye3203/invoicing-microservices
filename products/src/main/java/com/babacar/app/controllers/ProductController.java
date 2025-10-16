package com.babacar.app.controllers;

import com.babacar.app.dto.requests.CreateProductRequest;
import com.babacar.app.dto.responses.ProductResponse;
import com.babacar.app.services.GetProductService;
import com.babacar.app.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final GetProductService getProductService;

    @PostMapping
    @Operation(summary = "creation of a product")
    public ProductResponse create(
            @RequestBody CreateProductRequest request) throws IOException {
        return productService.createProduct(request);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "get a product by uuid")
    public ProductResponse getProduct(
            @PathVariable(name = "uuid") String uuid){
        return getProductService.getProduct(uuid);
    }

}

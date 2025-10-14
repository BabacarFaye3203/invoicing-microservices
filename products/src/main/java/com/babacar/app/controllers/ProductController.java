package com.babacar.app.controllers;

import com.babacar.app.dto.requests.CreateProductRequest;
import com.babacar.app.dto.responses.ProductResponse;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "creation of a product")
    public ProductResponse create(
            @RequestPart("request") CreateProductRequest request,
            @RequestParam MultipartFile file) throws IOException {
        return productService.createProduct(request,file);
    }

}

package com.shopsphere.product_service.controller;

import com.shopsphere.product_service.dto.ProductRequestDto;
import com.shopsphere.product_service.dto.ProductResponseDto;
import com.shopsphere.product_service.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product", description = "Product management APIs")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create a new product")
    @PostMapping("/")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    //GET	/products	Get all products (paginated)

    //GET	/products/{id}	Get product by ID

    //GET	/products/category/{categoryId}	Get products by category

    //PUT	/products/{id}	Update product (ADMIN)

}

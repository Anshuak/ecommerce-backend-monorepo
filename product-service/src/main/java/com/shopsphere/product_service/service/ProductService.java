package com.shopsphere.product_service.service;

import com.shopsphere.product_service.dto.ProductRequestDto;
import com.shopsphere.product_service.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    // create a new product
    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto);

    // get all products
    ResponseEntity<List<ProductResponseDto>> getAllProducts();

    // get product by id
    ResponseEntity<ProductResponseDto> getProductById(Long id);

    // get product by category id
    ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(Long categoryId);

    // update product by id
    ResponseEntity<ProductResponseDto> updateProduct(Long id, ProductRequestDto productRequestDto);
}

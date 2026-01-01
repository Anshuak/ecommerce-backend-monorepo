package com.shopsphere.product_service.service;

import com.shopsphere.product_service.dto.ProductRequestDto;
import com.shopsphere.product_service.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {

   // create a new product
    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto);
}

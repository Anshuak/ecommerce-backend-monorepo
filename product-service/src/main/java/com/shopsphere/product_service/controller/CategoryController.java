package com.shopsphere.product_service.controller;

import com.shopsphere.product_service.dto.CategoryRequestDto;
import com.shopsphere.product_service.dto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    // post: create a new category (ADMIN only)
    @PostMapping("/")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        // Implementation goes here
        return ResponseEntity.ok(new CategoryResponseDto());
    }

    // get: retrieve all categories (public)

    // get: retrieve a category by id (public)

    // put: update a category by id (ADMIN only)
}
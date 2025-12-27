package com.shopsphere.product_service.controller;

import com.shopsphere.product_service.dto.CategoryRequestDto;
import com.shopsphere.product_service.dto.CategoryResponseDto;
import com.shopsphere.product_service.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // post: create a new category (ADMIN only)
    @PostMapping("/")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    // get: retrieve all categories (public)
    @GetMapping("/")
    public ResponseEntity<java.util.List<CategoryResponseDto>> getAllCategories() {
        return categoryService.getAllCategories();
    }
    // get: retrieve a category by id (public)
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // put: update a category by id (ADMIN only)
}
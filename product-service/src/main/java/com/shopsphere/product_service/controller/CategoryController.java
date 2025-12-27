package com.shopsphere.product_service.controller;

import com.shopsphere.product_service.dto.CategoryRequestDto;
import com.shopsphere.product_service.dto.CategoryResponseDto;
import com.shopsphere.product_service.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Category management APIs")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // post: create a new category (ADMIN only)
    @Operation(summary = "Create a new category")
    @PostMapping("/")
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    // get: retrieve all categories (public)
    @Operation(summary = "Get all categories", description = "Returns a list of all categories")
    @GetMapping("/")
    public ResponseEntity<java.util.List<CategoryResponseDto>> getAllCategories() {
        return categoryService.getAllCategories();
    }
    // get: retrieve a category by id (public)
    @Operation(summary = "get category by id", description = "Returns a category by its id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // put: update a category by id (ADMIN only)
    @Operation(summary = "Update existing category")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id, categoryRequestDto);
    }
}
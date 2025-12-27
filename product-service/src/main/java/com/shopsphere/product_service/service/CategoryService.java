package com.shopsphere.product_service.service;

import com.shopsphere.product_service.dto.CategoryRequestDto;
import com.shopsphere.product_service.dto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    // create a new category
   public ResponseEntity<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto);

   // get all categories
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories();
//
//    // get category by id
//    public ResponseEntity<CategoryResponseDto> getCategoryById(Long id);
//
//    // update category by id
//    public ResponseEntity<CategoryResponseDto> updateCategory(Long id, CategoryResponseDto categoryResponseDto);
}

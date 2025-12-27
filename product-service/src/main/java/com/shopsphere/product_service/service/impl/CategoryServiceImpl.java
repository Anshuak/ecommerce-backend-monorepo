package com.shopsphere.product_service.service.impl;

import com.shopsphere.product_service.dto.CategoryRequestDto;
import com.shopsphere.product_service.dto.CategoryResponseDto;
import com.shopsphere.product_service.entity.Category;
import com.shopsphere.product_service.repository.CategoryRepository;
import com.shopsphere.product_service.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto) {
        // map DTO to entity
        Category category = modelMapper.map(categoryRequestDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto = modelMapper.map(savedCategory, CategoryResponseDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseDto);
    }
}

package com.shopsphere.product_service.service.impl;

import com.shopsphere.product_service.dto.ProductRequestDto;
import com.shopsphere.product_service.dto.ProductResponseDto;
import com.shopsphere.product_service.entity.Category;
import com.shopsphere.product_service.entity.Product;
import com.shopsphere.product_service.repository.CategoryRepository;
import com.shopsphere.product_service.repository.ProductRepository;
import com.shopsphere.product_service.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto) {
        // Validate category exists (many-to-one relationship)
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + productRequestDto.getCategoryId()));

        Product product = modelMapper.map(productRequestDto, Product.class);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = modelMapper.map(savedProduct, ProductResponseDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .toList();
        return ResponseEntity.ok(productResponseDtos);
    }

    @Override
    public ResponseEntity<ProductResponseDto> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        return ResponseEntity.ok(productResponseDto);
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> getProductsByCategoryId(Long categoryId) {
        List<Product> products = productRepository.getProductsByCategoryId(categoryId);
        List<ProductResponseDto> productResponseDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .toList();
        return ResponseEntity.ok(productResponseDtos);
    }

    @Override
    public ResponseEntity<ProductResponseDto> updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        // Update simple fields from the incoming DTO
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setSku(productRequestDto.getSku());
        product.setActive(productRequestDto.isActive());

        // Update category only when a categoryId is provided
        if (productRequestDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + productRequestDto.getCategoryId()));
            product.setCategory(category);
        }

        Product updatedProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = modelMapper.map(updatedProduct, ProductResponseDto.class);
        return ResponseEntity.ok(productResponseDto);
    }


}

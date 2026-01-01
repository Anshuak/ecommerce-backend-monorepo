package com.shopsphere.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String sku;
    private CategoryRequestDto category;
    private String categoryName;
    private boolean active;
    private Date createdAt;
    private Date updatedAt;
}

package com.shopsphere.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String sku;
    private Long categoryId;
    private boolean active;
}

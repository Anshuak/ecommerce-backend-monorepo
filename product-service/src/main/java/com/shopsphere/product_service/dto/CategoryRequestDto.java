package com.shopsphere.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private Date createdAt;
    private Date updatedAt;
}

package com.shopsphere.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    private Long id;
    @NotBlank(message = "Category name is required")
    private String name;
    private String description;
    @NotNull(message = "Status is required")
    private Boolean active;
    private Date createdAt;
    private Date updatedAt;
}

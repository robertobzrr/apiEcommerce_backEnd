package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.model.Category;
import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
}

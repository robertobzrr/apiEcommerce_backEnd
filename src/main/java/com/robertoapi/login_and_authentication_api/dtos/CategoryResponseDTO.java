package com.robertoapi.login_and_authentication_api.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryResponseDTO {
    private String name;
    private List<ProductResponseDTO> products;
}

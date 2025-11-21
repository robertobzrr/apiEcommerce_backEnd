package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryRequestDTO {
    private String name;
    private List<Product> products = new ArrayList<>();
}

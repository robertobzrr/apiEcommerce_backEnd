package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.model.Cart;
import com.robertoapi.login_and_authentication_api.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();
}

package com.robertoapi.login_and_authentication_api.dtos;

import com.robertoapi.login_and_authentication_api.enums.OrderStatusEnum;
import com.robertoapi.login_and_authentication_api.model.OrderItem;
import com.robertoapi.login_and_authentication_api.model.User;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    private String name;
    private OrderStatusEnum status;
    //private User user;
    private List<OrderItem> itens;
}

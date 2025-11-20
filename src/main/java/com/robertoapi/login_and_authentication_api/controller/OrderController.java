package com.robertoapi.login_and_authentication_api.controller;

import com.robertoapi.login_and_authentication_api.dtos.OrderRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.OrderResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Order;
import com.robertoapi.login_and_authentication_api.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

//------------------------------------------------------------------------------------------

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequestDTO orderDTO){
        orderService.createOrder(orderDTO);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDTO> findAllOrders(){
        return orderService.findAllOrders();
    }



}

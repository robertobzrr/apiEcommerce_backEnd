package com.robertoapi.login_and_authentication_api.service;

import com.robertoapi.login_and_authentication_api.dtos.OrderRequestDTO;
import com.robertoapi.login_and_authentication_api.dtos.OrderResponseDTO;
import com.robertoapi.login_and_authentication_api.model.Order;
import com.robertoapi.login_and_authentication_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

//------------------------------------------------------------------------------------------

    public void createOrder(OrderRequestDTO orderDTO){
        Order order = toEntity(orderDTO);
        orderRepository.save(order);
    }


    public List<OrderResponseDTO> findAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


//------------------------------------------------------------------------------------------
//DTOs

    private Order toEntity(OrderRequestDTO orderDTO){
        Order order = new Order();

        order.setName(orderDTO.getName());
        order.setStatus(orderDTO.getStatus());

        order.setUser(orderDTO.getUser());
        order.setItems(orderDTO.getItens());

        return order;
    }


    private OrderResponseDTO toResponseDTO(Order order){
        OrderResponseDTO respDTO = new OrderResponseDTO();

        respDTO.setName(order.getName());
        respDTO.setStatus(order.getStatus());
        respDTO.setUser(order.getUser());
        respDTO.setItens(order.getItems());


        return respDTO;
    }




}

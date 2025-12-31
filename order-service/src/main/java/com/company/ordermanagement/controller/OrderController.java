package com.company.ordermanagement.controller;

import com.company.ordermanagement.dto.CreateOrderRequest;
import com.company.ordermanagement.dto.OrderResponse;
import com.company.ordermanagement.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    //constructors
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest){

        return orderService.createOrder(createOrderRequest);
    }



}

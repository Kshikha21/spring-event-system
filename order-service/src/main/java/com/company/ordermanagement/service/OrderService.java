package com.company.ordermanagement.service;

import com.company.ordermanagement.dto.CreateOrderRequest;
import com.company.ordermanagement.dto.OrderResponse;
import com.company.ordermanagement.entity.Order;
import com.company.ordermanagement.event.OrderCreatedEvent;
import com.company.ordermanagement.repository.OrderRepository;


public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer ;

    public OrderService(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {

        // 1. Create order entity
        Order order = new Order(
                request.getUserId(),
                request.getAmount(),
                "CREATED"
        );

        // 2. Save order to DB
        Order savedOrder = orderRepository.save(order);

        // 3. (Later) Publish Kafka event here
        //create event
        OrderCreatedEvent event = new OrderCreatedEvent(savedOrder.getId(),
                savedOrder.getUserId(), savedOrder.getAmount());

        //4 Publish event to Kafka
        orderEventProducer.publishOrderCreatedEvent(event);

        return new OrderResponse(savedOrder.getId(), savedOrder.getStatus());
    }

}

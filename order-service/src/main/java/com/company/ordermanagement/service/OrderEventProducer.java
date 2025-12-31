package com.company.ordermanagement.service;

import com.company.ordermanagement.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
    private static final String TOPIC = "order-created";

    private final KafkaTemplate<String, Object> kafkaTemplate ;

    public OrderEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void publishOrderCreatedEvent(OrderCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}

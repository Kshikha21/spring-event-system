package com.company.inventory.consumer;

import com.company.events.OrderCreatedEvent;
import com.company.inventory.service.InventoryService;
import org.springframework.stereotype.Component;



@Component
public class OrderCreatedConsumer {
    private final InventoryService inventoryService;

    public OrderCreatedConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void consume(OrderCreatedEvent event){

    }
}

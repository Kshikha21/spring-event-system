package com.company.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processed_events")
public class ProcessedEvent {
    @Id
    private Long orderId;

    public ProcessedEvent(){

    }

    public ProcessedEvent (Long orderId){
        this.orderId = orderId;
    }

    public Long getOrderId(){
        return orderId;
    }

}

package com.company.ordermanagement.dto;

public class OrderResponse {

    private Long orderId;
    private String status;

    public OrderResponse(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}

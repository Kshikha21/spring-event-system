package com.company.ordermanagement.dto;

public class CreateOrderRequest {

    private String userId;
    private Double amount;

    public CreateOrderRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}


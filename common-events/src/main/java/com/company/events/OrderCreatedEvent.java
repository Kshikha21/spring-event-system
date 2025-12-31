package com.company.events;

public class OrderCreatedEvent
{
        private Long orderId;
        private String userId;
        private Double amount;

        public OrderCreatedEvent() {
        }

        public OrderCreatedEvent(Long orderId, String userId, Double amount) {
            this.orderId = orderId;
            this.userId = userId;
            this.amount = amount;
        }

        public Long getOrderId() {
            return orderId;
        }

        public String getUserId() {
            return userId;
        }

        public Double getAmount() {
            return amount;
        }
    }


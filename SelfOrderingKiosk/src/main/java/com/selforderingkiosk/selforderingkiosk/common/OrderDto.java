package com.selforderingkiosk.selforderingkiosk.common;

public class OrderDto {
    private Long orderId;
    private String type;
    private Double total;
    private String status;

    public OrderDto(Long orderId, String type, Double total, String status) {
        this.orderId = orderId;
        this.type = type;
        this.total = total;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getType() {
        return type;
    }

    public Double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }
}

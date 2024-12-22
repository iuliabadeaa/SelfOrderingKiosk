package com.selforderingkiosk.selforderingkiosk.common;

import entities.Order;

public class OrderedProductDto {
    private Long id;
    private String name;
    private Double price;
    private Long orderId;

    public OrderedProductDto(Long id, String name, double price, Long orderId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getOrderId() {
        return orderId;
    }
}

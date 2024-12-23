package com.selforderingkiosk.selforderingkiosk.common;

import entities.Order;

public class OrderedProductDto {
    private Long id;
    private String name;
    private Double price;
    private Long orderId;
    private Integer quantity;

    public OrderedProductDto(Long id, String name, double price, Long orderId, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderId = orderId;
        this.quantity = quantity;
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
    public Integer getQuantity() {
        return quantity;
    }
}

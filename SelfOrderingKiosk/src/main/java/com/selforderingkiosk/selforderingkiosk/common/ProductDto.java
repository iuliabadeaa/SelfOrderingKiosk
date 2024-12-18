package com.selforderingkiosk.selforderingkiosk.common;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long order_id;

    public ProductDto(Long id, String name, String description, Double price, Long order_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.order_id = order_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
    public Long getOrder_id() {
        return order_id;
    }
}

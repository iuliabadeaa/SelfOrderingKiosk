package com.selforderingkiosk.selforderingkiosk.common;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;

    public ProductDto(Long id, String name, String description, Double price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
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

    public String getCategory() {
        return category;
    }
}

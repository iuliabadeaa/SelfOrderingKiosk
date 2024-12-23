package com.selforderingkiosk.selforderingkiosk.common;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String image;

    public ProductDto(Long id, String name, String description, Double price, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
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

    public String getImage() { return image; }
}

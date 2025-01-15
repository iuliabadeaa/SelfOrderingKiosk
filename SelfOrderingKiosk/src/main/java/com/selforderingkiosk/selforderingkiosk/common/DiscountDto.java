package com.selforderingkiosk.selforderingkiosk.common;

public class DiscountDto {
    private Long id;
    private String code;

    public DiscountDto(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

}

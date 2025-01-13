package com.selforderingkiosk.selforderingkiosk.common;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;

    public UserDto(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}

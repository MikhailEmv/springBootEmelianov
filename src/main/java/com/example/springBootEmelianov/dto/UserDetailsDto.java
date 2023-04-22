package com.example.springBootEmelianov.dto;

public class UserDetailsDto {

    private String username;
    private String role;

    public UserDetailsDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}

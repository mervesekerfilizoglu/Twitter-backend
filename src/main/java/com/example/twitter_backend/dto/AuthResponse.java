package com.example.twitter_backend.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserDto user;
}
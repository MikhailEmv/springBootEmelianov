package com.example.springBootEmelianov.controller;

import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.Map;

abstract public class ApiController {

    public Map<String, String> getUserDetails(Authentication authentication) {
        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("username", authentication.getName());
        userDetails.put("role", authentication.getAuthorities().toString());
        return userDetails;
    }
}

package com.example.springBootEmelianov.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/public/api")
public class PublicApiController extends ApiController {

    @GetMapping
    public Map<String, String> getPublicData(Authentication authentication) {
        return getUserDetails(authentication);
    }

}

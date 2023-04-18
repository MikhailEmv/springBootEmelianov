package com.example.springBootEmelianov.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@RestController
@RequestMapping("/support/api")
@RolesAllowed("SUPPORT")
public class SupportApiController extends ApiController {

    @GetMapping
    public Map<String, String> getSupportData(Authentication authentication) {
        return getUserDetails(authentication);
    }

}
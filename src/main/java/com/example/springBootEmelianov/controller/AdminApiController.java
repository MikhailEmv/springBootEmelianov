package com.example.springBootEmelianov.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Map;

@RestController
@RequestMapping("/admin/api")
@RolesAllowed("ADMIN")
public class AdminApiController extends ApiController {

    @GetMapping
    public Map<String, String> getAdminData(Authentication authentication) {
        return getUserDetails(authentication);
    }

}

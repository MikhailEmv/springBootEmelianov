package com.example.springBootEmelianov.controller;

import com.example.springBootEmelianov.dto.UserDetailsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/public/api")
    public UserDetailsDto publicApi(Principal principal) {
        return new UserDetailsDto(principal.getName(), "PUBLIC");
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping("/admin/api")
    public UserDetailsDto adminApi(Principal principal) {
        return new UserDetailsDto(principal.getName(), "ADMIN");
    }

    @RolesAllowed({"SUPPORT"})
    @GetMapping("/support/api")
    public UserDetailsDto supportApi(Principal principal) {
        return new UserDetailsDto(principal.getName(), "SUPPORT");
    }
}

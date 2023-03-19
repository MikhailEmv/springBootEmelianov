package com.example.springBootEmelianov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/headers")
public class HeaderController {

    @GetMapping("/getAllHeaders")
    public ResponseEntity<Map<String, String>> getAllHeaders(@RequestHeader Map<String, String> headers) {
        return ResponseEntity.ok(headers);
    }
}

package com.example.springBootEmelianov.controller;

import com.example.springBootEmelianov.controller.dto.MyDto;
import com.example.springBootEmelianov.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("example")
@RequiredArgsConstructor
@Validated
public class MyController {

    private final MyService myService;

    @PostMapping("extension")
    public MyDto getOneYearExtension(@Valid @RequestBody MyDto myDto) {
        return myService.changeAge(myDto);
    }
}

package com.example.springBootEmelianov.service.impl;

import com.example.springBootEmelianov.controller.dto.MyDto;
import com.example.springBootEmelianov.service.MyService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public MyDto changeAge(@NotNull MyDto myDto) {
        myDto.setAge(myDto.getAge() + 1);
        return myDto;
    }
}

package com.example.springBootEmelianov.service.impl;

import com.example.springBootEmelianov.controller.dto.MyDto;
import com.example.springBootEmelianov.exception.MyException;
import com.example.springBootEmelianov.service.MyService;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public MyDto addId(MyDto input) {
        if (input.getInfo().getId() == 123) {
            throw new MyException("503 error");
        }

        input.getInfo().setId(123);
        return input;
    }
}

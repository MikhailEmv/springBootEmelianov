package com.example.springBootEmelianov.controller;

import com.example.springBootEmelianov.controller.dto.MyDto;
import com.example.springBootEmelianov.exception.MyException;
import com.example.springBootEmelianov.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("json")
public class JsonController {

    private final MyService myService;

    @PatchMapping("send")
    public MyDto sendToService(@RequestBody MyDto myDto) {
        return myService.addId(myDto);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleException(MyException ex) {
        return status(HttpStatus.BAD_GATEWAY).body(ex.getMessage());
    }
}

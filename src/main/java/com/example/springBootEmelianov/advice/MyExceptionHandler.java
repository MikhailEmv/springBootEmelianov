package com.example.springBootEmelianov.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Map<String, String>> handleBindException(BindException ex) {

        List<Map<String, String>> errors = new ArrayList<>();

        ex.getFieldErrors().forEach(error -> {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("field", error.getField());
            errorDetails.put("message", error.getDefaultMessage());
            errors.add(errorDetails);
        });
        return errors;
    }
}

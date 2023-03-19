package com.example.springBootEmelianov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/headers")
public class HeaderController {

    @GetMapping("/getAllHeaders")
    public String getHeaders(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        request.getHeaderNames().asIterator().forEachRemaining(headerName ->
                stringBuilder.append(headerName).append(": ")
                        .append(request.getHeader(headerName)).append("\n"));
        return stringBuilder.toString();
    }
}


//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "example")
//public class controller {
//
//    @GetMapping("test")
//    public String testMethod(@RequestParam(name="test") Boolean test) {
//        if (test) {
//            return "all is good";
//        }
//        return "all is bad";
//    }
//
//    @GetMapping("lol/{id}")
//    public String lolMethod(@PathVariable(name="id") Integer number) {
//        if (number >= 52) {
//            return "all is good";
//        }
//        return "all is bad";
//    }
//
//    @GetMapping("body")
//    public String bodyMethod(@RequestBody String name) {
//        return "body: " + name;
//    }
//}
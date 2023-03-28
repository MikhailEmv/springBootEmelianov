package com.example.springBootEmelianov.controller.dto;

import com.example.springBootEmelianov.controller.validation.NameFormChecking;
import com.example.springBootEmelianov.controller.validation.PensionAge;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MyDto {

    @PensionAge
    private int age;

    @NameFormChecking
    private String name;

    @NameFormChecking(message = "Your surname form is not correct")
    private String surname;

    @NotBlank(message = "The city field must not be empty")
    private String city;
}

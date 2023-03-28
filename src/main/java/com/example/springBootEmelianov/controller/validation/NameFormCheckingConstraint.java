package com.example.springBootEmelianov.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameFormCheckingConstraint implements ConstraintValidator<NameFormChecking, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Character.isUpperCase(value.charAt(0));
    }
}

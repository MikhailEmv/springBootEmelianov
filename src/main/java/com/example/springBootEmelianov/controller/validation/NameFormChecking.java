package com.example.springBootEmelianov.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameFormCheckingConstraint.class)
public @interface NameFormChecking {

    String message() default "Your name form is not correct";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

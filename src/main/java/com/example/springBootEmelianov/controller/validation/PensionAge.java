package com.example.springBootEmelianov.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Min(value = 64, message = "It is not time to get retired in Russia")
@Max(value = 65, message = "It is high time to get retired in Russia")
@Documented
@Constraint(validatedBy = { })
public @interface PensionAge {

    String message() default "About retiring";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

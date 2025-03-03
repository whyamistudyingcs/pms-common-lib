package com.fdm.pmscommon.dto.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fdm.pmscommon.dto.validation.validator.NonZeroValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NonZeroValidator.class)
public @interface NonZero {
    String message() default "Quantity cannot be zero";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

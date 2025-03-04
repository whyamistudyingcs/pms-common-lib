package com.fdm.pmscommon.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import com.fdm.pmscommon.dto.validation.validator.DateRangeValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface ValidDateRange {
    String message() default "Start date must be before or equal to end date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
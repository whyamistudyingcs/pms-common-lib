package com.fdm.pmscommon.dto.validation.validator;

import com.fdm.pmscommon.dto.validation.NonZero;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonZeroValidator implements ConstraintValidator<NonZero, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value != 0;
    }
    
    @Override
    public void initialize(NonZero constraintAnnotation) {
        // No initialization needed
    }
}

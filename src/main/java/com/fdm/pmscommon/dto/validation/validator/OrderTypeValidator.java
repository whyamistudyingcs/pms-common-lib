package com.fdm.pmscommon.dto.validation.validator;

import com.fdm.pmscommon.dto.validation.ValidOrderType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderTypeValidator implements ConstraintValidator<ValidOrderType, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.toUpperCase().equals("BUY") || s.toUpperCase().equals("SELL")) return true;
        return false;
    }
}

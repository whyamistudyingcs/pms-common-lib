package com.fdm.pmscommon.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fdm.pmscommon.dto.validation.ValidDate;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(s != null) {
            try {
                LocalDate.parse(s, DATE_FORMATTER);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
}

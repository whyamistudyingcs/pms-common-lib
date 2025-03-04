package com.fdm.pmscommon.dto.validation.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanWrapperImpl;

import com.fdm.pmscommon.dto.incoming.TradeHistoryRequestDto;
import com.fdm.pmscommon.dto.validation.ValidDateRange;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class DateRangeValidator implements ConstraintValidator<ValidDateRange, TradeHistoryRequestDto> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(TradeHistoryRequestDto request, ConstraintValidatorContext context) {
        if (request.getStartDate() == null || request.getEndDate() == null) {
            return true; // Let @NotBlank handle null values
        }

        try {
            LocalDate startDate = LocalDate.parse(request.getStartDate(), DATE_FORMATTER);
            LocalDate endDate = LocalDate.parse(request.getEndDate(), DATE_FORMATTER);

            // Check if startDate is before or equal to endDate
            return !startDate.isAfter(endDate);
        } catch (Exception e) {
            // Handle parsing errors (e.g., invalid date format)
            return false;
        }
    }

}

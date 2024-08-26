package com.example.restdemo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CheckContractCurValidator implements ConstraintValidator<CheckContractCur, String> {

    private List<String> acceptedValues;
    private String defaultMessage;

    private static final String CONTRACT_CUR_CODE_MSG = "Поле ContractCur имеет недопустимый валютный код: (%s)";

    @Override
    public void initialize(CheckContractCur constraintAnnotation) {
        acceptedValues = Arrays.stream(constraintAnnotation.curVal())
                .map(Enum::name)
                .toList();
        defaultMessage = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String trimmedValue = Optional.ofNullable(value).map(String::trim).orElse(null);

        if (trimmedValue == null || trimmedValue.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(defaultMessage)
                    .addConstraintViolation();
            return false;
        }

        if (!acceptedValues.contains(trimmedValue)) {
            String errorMessage = String.format(CONTRACT_CUR_CODE_MSG, trimmedValue);
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage)
                    .addConstraintViolation();
            return false;
        }

        return true; // Успешная валидация
    }
}

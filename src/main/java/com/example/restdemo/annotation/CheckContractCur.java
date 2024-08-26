package com.example.restdemo.annotation;

import com.example.restdemo.ContractCur;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckContractCurValidator.class)
public @interface CheckContractCur {

    ContractCur[] curVal();

    String message() default "Отсутствует параметр ContractCur (валюта)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
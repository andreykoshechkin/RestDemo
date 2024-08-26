package com.example.restdemo.exception;

import com.example.restdemo.data.Result;
import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {
    private final Result result;

    public CustomValidationException(Result result, String message) {
        super(message);
        this.result = result;
    }

}
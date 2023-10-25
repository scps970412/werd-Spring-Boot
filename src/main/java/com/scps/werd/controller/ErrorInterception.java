package com.scps.werd.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorInterception {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> handleBindException(BindException ex) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        List<String> errorMessages = fieldErrors.stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}

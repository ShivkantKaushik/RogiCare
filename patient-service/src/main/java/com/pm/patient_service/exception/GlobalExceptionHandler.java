package com.pm.patient_service.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){

        Map<String,String> errors = ex.getBindingResult().getFieldErrors().stream().
                collect(Collectors.toMap( error -> error.getField(), error -> error.getDefaultMessage() ));

        return ResponseEntity.badRequest().body(errors);
    }
}

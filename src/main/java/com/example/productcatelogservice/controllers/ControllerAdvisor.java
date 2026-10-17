package com.example.productcatelogservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({IllegalArgumentException.class , RuntimeException.class})
    private ResponseEntity<String> handleIllegalException(Exception exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.BAD_REQUEST);
    }
}

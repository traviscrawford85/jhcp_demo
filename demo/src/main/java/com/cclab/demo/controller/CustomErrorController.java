package com.cclab.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleException(Throwable ex) {
        // Log the error details here
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Custom error message");
    }

}

package com.cclab.demo.handler;

import com.cclab.demo.dto.ErrorResponse;
import com.cclab.demo.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProviderService.ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ProviderService.ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // You can add more handlers for different types of exceptions
}

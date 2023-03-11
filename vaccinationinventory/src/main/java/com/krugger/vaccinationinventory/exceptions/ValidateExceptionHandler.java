package com.krugger.vaccinationinventory.exceptions;

import com.krugger.vaccinationinventory.dto.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidateExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ValidateExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<ResponseError> handleValidationException(MethodArgumentNotValidException ex) {
        logger.error("Error validation data ", ex);

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST, "validation errors", errors);

        return new ResponseEntity<ResponseError>(response, HttpStatus.BAD_REQUEST);
    }
}

package com.krugger.vaccinationinventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ResponseError {

    private HttpStatus status;
    private String message;
    private List<String> errors;
}

package com.krugger.vaccinationinventory.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class SwaggerController {

    @GetMapping("/api")
    @Hidden
    public ResponseEntity<Object> documentation() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/swagger-ui/index.html#/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
package com.krugger.vaccinationinventory.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class EmployeeCreateDTO {

    @NotNull(message = "Identification field is required")
    @NotEmpty(message = "Identification field must not be empty")
    @Digits(integer = 10, fraction = 0, message = "Identification must be numeric")
    @Size(min = 10, max = 10, message = "The Identification must have 10 digits")
    @Parameter(name = "dni", required = true, description = "employee identification number", example = "0988742354")
    private String dni;

    @NotNull(message = "Name field is required")
    @NotEmpty(message = "The name field must not be empty")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Names can only contain letters")
    @Size(min = 2, max = 50, message = "Names must have a minimum of 2 characters and a maximum of 100 characters")
    private String name;

    @NotNull(message = "Last name field required")
    @NotEmpty(message = "The last name field must not be empty")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Last name can only contain letters")
    @Size(min = 2, max = 50, message = "Last name must have a minimum of 2 characters and a maximum of 100 characters")
    private String lastname;

    @Email(message = "Incorrectly formatted email")
    @NotNull(message = "Email field required")
    @NotEmpty(message = "The Email field must not be empty")
    @Parameter(required = true, description = "Email of employee", example = "juan.maldonado@devnull.com")
    private String email;


    private LocalDate birthdate;


    private String address;


    private String celphone;


}

package com.krugger.vaccinationinventory.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.krugger.vaccinationinventory.models.enums.VaccineType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class VaccinationEmployeeDTO {

    @NotNull
    private Long id;

    @NotNull
    private VaccineType typeVaccine;

    @NotNull
    private LocalDate vaccinatedAt;

    @NotNull
    private Integer doseNumber;

    @JsonIgnore
    private EmployeeDTO employee;

}

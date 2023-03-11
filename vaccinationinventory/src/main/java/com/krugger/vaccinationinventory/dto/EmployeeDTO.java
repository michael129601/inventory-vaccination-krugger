package com.krugger.vaccinationinventory.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    private String dni;

    private String name;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private String address;

    private String celphone;

    private UserDTO user;

    private String vaccinationStatus;

    private List<VaccinationEmployeeDTO> vaccinationEmployee;

}

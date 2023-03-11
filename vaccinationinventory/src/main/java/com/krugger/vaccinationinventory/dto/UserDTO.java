package com.krugger.vaccinationinventory.dto;

import com.krugger.vaccinationinventory.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private RoleDTO rol;
}

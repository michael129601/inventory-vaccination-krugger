package com.krugger.vaccinationinventory.mapper;


import com.krugger.vaccinationinventory.dto.EmployeeCreateDTO;
import com.krugger.vaccinationinventory.models.Employee;
import org.springframework.stereotype.Component;


@Component
public  class EmployeeCreateMapper extends MapperBase<EmployeeCreateDTO,Employee> {

    @Override
    protected Class getDTOClass() {
        return EmployeeCreateDTO.class;
    }

    @Override
    protected Class getEntityClass() {
        return Employee.class;
    }
}

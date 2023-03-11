package com.krugger.vaccinationinventory.mapper;

import com.krugger.vaccinationinventory.dto.EmployeeDTO;
import com.krugger.vaccinationinventory.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper extends MapperBase<EmployeeDTO, Employee>{
    @Override
    protected Class<EmployeeDTO> getDTOClass() {
        return EmployeeDTO.class;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}

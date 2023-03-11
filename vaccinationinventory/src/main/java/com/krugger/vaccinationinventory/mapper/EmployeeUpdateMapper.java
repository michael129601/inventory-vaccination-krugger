package com.krugger.vaccinationinventory.mapper;


import com.krugger.vaccinationinventory.dto.EmployeeCreateDTO;
import com.krugger.vaccinationinventory.dto.EmployeeUpdateDTO;
import com.krugger.vaccinationinventory.models.Employee;
import org.hibernate.annotations.Parent;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;


@Component
public  class EmployeeUpdateMapper extends MapperBase<EmployeeUpdateDTO,Employee> {

    @Override
    protected Class<EmployeeUpdateDTO> getDTOClass() {
        return EmployeeUpdateDTO.class;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }


    public void toEntity(EmployeeUpdateDTO dto, Employee employee) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(dto,employee);
    }
}

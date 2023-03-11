package com.krugger.vaccinationinventory.services.contract;


import com.krugger.vaccinationinventory.models.Employee;
import com.krugger.vaccinationinventory.models.enums.VaccinationStatus;
import com.krugger.vaccinationinventory.models.enums.VaccineType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IEmployeeService {

    Employee create(Employee employee) throws Exception;


    Employee update(Employee employee) throws Exception;

    List<Employee> getAll() throws Exception;

    Employee getById(Long id);

    List<Employee> getByStatusVaccination(VaccinationStatus status);

    void delete(Long id);

    void refresh(Employee employee);

    List<Employee> getByVaccinationType(VaccineType type);


    List<Employee> getByBetweenVaccinationAt(LocalDate startDate, LocalDate EndDate);

}

package com.krugger.vaccinationinventory.services;


import com.krugger.vaccinationinventory.exceptions.UniqueViolationException;
import com.krugger.vaccinationinventory.exceptions.VaccinationDataEmptyException;
import com.krugger.vaccinationinventory.models.Employee;
import com.krugger.vaccinationinventory.exceptions.ModelNotFoundException;
import com.krugger.vaccinationinventory.models.VaccinationEmployee;
import com.krugger.vaccinationinventory.models.enums.VaccinationStatus;
import com.krugger.vaccinationinventory.models.enums.VaccineType;
import com.krugger.vaccinationinventory.repositories.EmployeeRepository;
import com.krugger.vaccinationinventory.repositories.VaccinationEmployeeRepository;
import com.krugger.vaccinationinventory.services.contract.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Autowired
    private VaccinationEmployeeRepository vaccinationEmployeeRepository;


    public Employee create(Employee employee) throws Exception {
        boolean existsEmployee = employeeRepository.findByDni(employee.getDni()) != null;
        if (existsEmployee){
            throw new UniqueViolationException(
                    String.format("the employee with ID %s already exists", employee.getDni()));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) throws Exception {

        boolean isVaccinated = employee.getVaccinationStatus().equals(VaccinationStatus.VACUNADO);

        if (isVaccinated && employee.getVaccinationEmployee().isEmpty()){
            throw new VaccinationDataEmptyException("Vaccination information is mandatory");
        }

        List<VaccinationEmployee> vaccinations = employee.getVaccinationEmployee();
        vaccinations.removeIf(v -> v.getVaccinatedAt() == null);

        for (VaccinationEmployee vaccination : vaccinations) {
            vaccination.setEmployee(employee);
        }

        employee.setVaccinationEmployee(vaccinations);

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() throws Exception {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ModelNotFoundException("Employee Not Found"));
    }

    @Override
    public List<Employee> getByStatusVaccination(VaccinationStatus status) {
        return employeeRepository.findByVaccinationStatus(status);
    }
    @Override
    public void delete(Long id) {
        Employee employee = this.getById(id);
        employeeRepository.delete(employee);
    }

    public List<Employee> getByVaccinationType(VaccineType type){
        return employeeRepository.findByVaccinationEmployeeTypeVaccine(type);
    }

    @Override
    public List<Employee> getByBetweenVaccinationAt(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findByVaccinationEmployee_VaccinatedAtBetween(startDate,endDate);
    }

    public void refresh(Employee employee){
        employee = this.getById(employee.getId());
    }

}

package com.krugger.vaccinationinventory.repositories;

import com.krugger.vaccinationinventory.models.Employee;
import com.krugger.vaccinationinventory.models.enums.VaccinationStatus;
import com.krugger.vaccinationinventory.models.enums.VaccineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByDni(String dni);

    List<Employee> findByVaccinationStatus(VaccinationStatus status);

    List<Employee> findByVaccinationEmployeeTypeVaccine(VaccineType typeVaccine);

    List<Employee> findByVaccinationEmployee_VaccinatedAtBetween(LocalDate startDate, LocalDate endDate);


}
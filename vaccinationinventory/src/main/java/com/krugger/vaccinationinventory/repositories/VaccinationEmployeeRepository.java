package com.krugger.vaccinationinventory.repositories;

import com.krugger.vaccinationinventory.models.VaccinationEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VaccinationEmployeeRepository extends JpaRepository<VaccinationEmployee, Long> {

    List<VaccinationEmployeeRepository> findByVaccinatedAtBetween(Date startDate, Date endDate);

}
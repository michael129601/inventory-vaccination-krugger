package com.krugger.vaccinationinventory.services.contract;

import com.krugger.vaccinationinventory.repositories.VaccinationEmployeeRepository;

import java.util.Date;
import java.util.List;

public interface IVaccinationEmployeeService {

    List<VaccinationEmployeeRepository> findByVaccinatedAtBetween(Date startDate, Date endDate);

}

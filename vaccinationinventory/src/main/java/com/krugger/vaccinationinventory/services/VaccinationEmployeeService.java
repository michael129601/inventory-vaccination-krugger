package com.krugger.vaccinationinventory.services;

import com.krugger.vaccinationinventory.repositories.VaccinationEmployeeRepository;
import com.krugger.vaccinationinventory.services.contract.IVaccinationEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class VaccinationEmployeeService implements IVaccinationEmployeeService {

    @Autowired
    private VaccinationEmployeeRepository vaccinationEmployeeRepository;

    @Override
    public List<VaccinationEmployeeRepository> findByVaccinatedAtBetween(Date startDate, Date endDate) {
        return vaccinationEmployeeRepository.findByVaccinatedAtBetween(startDate,endDate);
    }
}

package com.krugger.vaccinationinventory.init;

import com.krugger.vaccinationinventory.Constants;
import com.krugger.vaccinationinventory.models.Employee;
import com.krugger.vaccinationinventory.models.Role;
import com.krugger.vaccinationinventory.repositories.EmployeeRepository;
import com.krugger.vaccinationinventory.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class InitialData {

    @Autowired
    private RoleRepository roleRepository;


    @PostConstruct
    public void loadData() {
        // load initial data role
        for (Map.Entry<String, String> role : Constants.roles.entrySet()) {
            Role roleEntity = new Role();
            roleEntity.setName(role.getKey().toLowerCase());
            roleEntity.setAbbreviation(role.getValue());
            roleRepository.save(roleEntity);
        }
    }
}

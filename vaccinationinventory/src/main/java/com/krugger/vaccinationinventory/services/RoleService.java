package com.krugger.vaccinationinventory.services;

import com.krugger.vaccinationinventory.models.Role;
import com.krugger.vaccinationinventory.repositories.RoleRepository;
import com.krugger.vaccinationinventory.services.contract.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) throws Exception {
        return roleRepository.save(role);
    }

    @Override
    public Role finByAbbreviation(String abbreviation) throws Exception {
        return roleRepository.findByAbbreviation(abbreviation);
    }
}

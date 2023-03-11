package com.krugger.vaccinationinventory.repositories;

import com.krugger.vaccinationinventory.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByAbbreviation(String abbreviation);

}
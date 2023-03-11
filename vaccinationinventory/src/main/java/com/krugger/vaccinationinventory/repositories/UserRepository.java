package com.krugger.vaccinationinventory.repositories;

import com.krugger.vaccinationinventory.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
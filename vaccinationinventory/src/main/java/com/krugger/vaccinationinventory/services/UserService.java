package com.krugger.vaccinationinventory.services;

import com.krugger.vaccinationinventory.exceptions.ModelNotFoundException;
import com.krugger.vaccinationinventory.models.User;
import com.krugger.vaccinationinventory.repositories.UserRepository;
import com.krugger.vaccinationinventory.services.contract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow( ()-> new ModelNotFoundException("User Not Found"));
    }

}

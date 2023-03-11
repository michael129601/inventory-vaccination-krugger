package com.krugger.vaccinationinventory.services.contract;

import com.krugger.vaccinationinventory.models.User;

public interface IUserService {

    User create(User user) throws Exception;

    User getById(Long id) throws Exception;


}

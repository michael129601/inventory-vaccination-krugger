package com.krugger.vaccinationinventory.events.listeners;

import com.krugger.vaccinationinventory.Constants;
import com.krugger.vaccinationinventory.events.EmployeeCreated;
import com.krugger.vaccinationinventory.models.User;
import com.krugger.vaccinationinventory.services.UserService;
import com.krugger.vaccinationinventory.services.contract.IRoleService;
import com.krugger.vaccinationinventory.services.contract.IUserService;
import com.krugger.vaccinationinventory.utils.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GenerateCredentialHandler implements ApplicationListener<EmployeeCreated> {

    private static final Logger logger = LoggerFactory.getLogger(GenerateCredentialHandler.class);

    @Autowired
    private IUserService userService;


    @Autowired
    private IRoleService roleService;


    @Override
    public void onApplicationEvent(EmployeeCreated event){
        User user = new User();
        user.setEmployee(event.getEmployee());
        user.setUsername(Credentials.generateUsername(event.getEmployee().getEmail()));
        user.setPassword(Credentials.generatePassword());

        try {
            user.setRol(roleService.finByAbbreviation(Constants.roles.get("EMPLOYEE")));
            userService.create(user);
        } catch (Exception e) {
            logger.error("error generation user to employee "+event.getEmployee().getId(),e);
            throw new RuntimeException(e);
        }
    }
}

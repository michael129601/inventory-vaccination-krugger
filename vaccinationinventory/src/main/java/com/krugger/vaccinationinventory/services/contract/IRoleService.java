package com.krugger.vaccinationinventory.services.contract;

import com.krugger.vaccinationinventory.models.Role;

public interface IRoleService {

    public Role create(Role role) throws Exception;

    public Role finByAbbreviation(String abbreviation)  throws Exception;

}

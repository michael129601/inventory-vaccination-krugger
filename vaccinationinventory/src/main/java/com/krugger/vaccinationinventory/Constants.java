package com.krugger.vaccinationinventory;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<String, String> roles = new HashMap<String, String>() {{
        put("ADMINISTRATOR", "ADMIN");
        put("EMPLOYEE", "EMPLOYEE");
    }};

}

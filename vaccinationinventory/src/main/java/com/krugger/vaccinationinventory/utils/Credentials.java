package com.krugger.vaccinationinventory.utils;

public class Credentials {

    private final static  Integer LENGTH_PASSWORD=20;

    public static String generateUsername(String email){
        return email.split("@")[0];
    }

    public static String generatePassword(){
        return PasswordGenerator.generatePassword(Credentials.LENGTH_PASSWORD);
    }

}

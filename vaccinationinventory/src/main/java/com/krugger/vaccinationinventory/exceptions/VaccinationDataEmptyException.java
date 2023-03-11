package com.krugger.vaccinationinventory.exceptions;


public class VaccinationDataEmptyException extends RuntimeException{

    public VaccinationDataEmptyException(String message){
        super(message);
    }
}

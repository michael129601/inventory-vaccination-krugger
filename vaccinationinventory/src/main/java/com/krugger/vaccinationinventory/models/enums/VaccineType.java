package com.krugger.vaccinationinventory.models.enums;

public enum VaccineType {

    PFIZER("_PFIZER"),
    MODERNA("_MODERNA"),
    ASTRAZENECA("_ASTRAZENECA"),
    JOHNSON_AND_JOHNSON("_JOHNSON_&_JOHNSON");

    private final String type;

    VaccineType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

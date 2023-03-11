package com.krugger.vaccinationinventory.models.enums;

import jakarta.validation.constraints.NotNull;

public enum VaccinationStatus {

    VACUNADO("_VACUNADO"),
    NO_VACUNADO("_NO_VACUNADO");

    @NotNull
    private final String status;

    VaccinationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

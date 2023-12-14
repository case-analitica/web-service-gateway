package com.caseanalitica.webservicegateway.app.dto.commons;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CalibrationStatus {

    REALIZED("Realizado"),
    PROGRAMMED("Programado"),
    INACTIVE("Inativo");

    private final String value;

    CalibrationStatus(String value) {
        this.value = value;
    }

    @JsonValue
    final String value() {
        return this.value;
    }

    public static CalibrationStatus getName(String value) {
        return Arrays.stream(CalibrationStatus.values()).filter(calibrationStatus -> calibrationStatus.getValue().equals(value)).toList().get(0);
    }

}

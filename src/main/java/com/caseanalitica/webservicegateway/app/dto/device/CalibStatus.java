package com.caseanalitica.webservicegateway.app.dto.device;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum CalibStatus {

    REALIZED("Realizado"),
    PROGRAMMED("Programado"),
    INACTIVE("Inativo");

    private final String value;

    CalibStatus(String value) {
        this.value = value;
    }

    @JsonValue
    final String value(){
        return this.value;
    }

}

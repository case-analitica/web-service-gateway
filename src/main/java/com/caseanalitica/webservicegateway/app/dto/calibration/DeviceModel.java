package com.caseanalitica.webservicegateway.app.dto.calibration;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeviceModel {

    private Long id;
    private String model;
    private String manufacturer;

}

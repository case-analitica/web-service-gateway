package com.caseanalitica.webservicegateway.app.dto.device;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceResponse {

    private Long id;
    private String description;
    private String localization;
    private String deviceGroup;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String tag;
    private CalibStatus calibStatus;

}

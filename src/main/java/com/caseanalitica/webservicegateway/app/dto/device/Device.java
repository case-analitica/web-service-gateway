package com.caseanalitica.webservicegateway.app.dto.device;


import com.caseanalitica.webservicegateway.app.dto.commons.Manufacturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {

    private Long id;
    private String description;
    private String localization;
    private String deviceGroup;
    private Manufacturer deviceManufacturer;
    private String model;
    private String serialNumber;
    private String tag;
    private CalibrationStatus calibrationStatus;

}

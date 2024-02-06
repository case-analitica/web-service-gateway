package com.caseanalitica.webservicegateway.app.dto.device;

import com.caseanalitica.webservicegateway.app.dto.commons.Manufacturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {

    private Long id;

    private String control;

    private DeviceModel model;

    private String serialNumber;

    private String tag;

    private String customerId;

    private String accessories;

    private DeviceType type;

    private DeviceGroup group;

    private Manufacturer manufacturer;

    private String notes;


}

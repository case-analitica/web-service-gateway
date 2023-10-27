package com.caseanalitica.webservicegateway.app.dto.customerdevice;

import com.caseanalitica.webservicegateway.app.dto.commons.Manufacturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDevice {

    private Long id;

    private String control;

    private CustomerDeviceModel model;

    private String serialNumber;

    private String tag;

    private String customerId;

    private String accessories;

    private CustomerDeviceType customerDeviceType;

    private Manufacturer manufacturer;

    private String notes;


}

package com.caseanalitica.webservicegateway.app.dto.customerdevice;

import com.caseanalitica.webservicegateway.app.dto.commons.Manufacturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDeviceModel {

    private Long id;

    private String model;

    private Manufacturer manufacturer;

}

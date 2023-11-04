package com.caseanalitica.webservicegateway.app.dto.customerdevice;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerDeviceGroup implements Serializable {

    private Long id;

    private String group;

    private Boolean status;

}

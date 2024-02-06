package com.caseanalitica.webservicegateway.app.dto.device;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DeviceGroup implements Serializable {

    private Long id;

    private String name;

}

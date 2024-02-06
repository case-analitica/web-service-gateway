package com.caseanalitica.webservicegateway.app.dto.standard;

import com.caseanalitica.webservicegateway.app.dto.commons.Group;
import com.caseanalitica.webservicegateway.app.dto.commons.Manufacturer;
import com.caseanalitica.webservicegateway.app.dto.commons.ToolGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Standard {

    private Long id;
    private String description;
    private ToolGroup toolGroup;
    private Group group;
    private Manufacturer manufacturer;
    private StandardName standardName;
    private String serialNumber;
    private String tag;

}

package com.caseanalitica.webservicegateway.app.dto;

import com.caseanalitica.webservicegateway.cross.utils.Data;
import com.caseanalitica.webservicegateway.cross.utils.Meta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private Integer code;
    private String status;
    private Meta meta;
    private Data data;

}

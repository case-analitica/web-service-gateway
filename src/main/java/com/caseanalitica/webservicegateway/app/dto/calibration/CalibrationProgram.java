package com.caseanalitica.webservicegateway.app.dto.calibration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalibrationProgram {

    private Long id;

    private DeviceModel deviceModel;

    private String calibrationPoints;

    private String acceptanceCriteria;

}

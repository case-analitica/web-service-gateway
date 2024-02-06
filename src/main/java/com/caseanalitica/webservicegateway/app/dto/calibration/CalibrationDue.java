package com.caseanalitica.webservicegateway.app.dto.calibration;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalibrationDue {

    private Long id;

    private String serialNumber;

    private String tag;

    private DeviceModel deviceModel;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String calibrationDate;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String nextCalibration;

}

package com.caseanalitica.webservicegateway.app.dto.calibration;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CalibrationDue {

    private Long id;

    private String serialNumber;

    private String tag;

    private DeviceModel deviceModel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate calibrationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate nextCalibration;

}

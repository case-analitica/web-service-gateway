package com.caseanalitica.webservicegateway.app.dto.calibration;

import com.caseanalitica.webservicegateway.app.dto.commons.CalibrationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalibrationControl {

    private Long id;

    private String serialNumber;

    private String tag;

    private DeviceModel deviceModel;

    private CalibrationProgram calibrationProgram;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate calibrationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate nextCalibration;

    private String certificateDocument;

    private CalibrationStatus calibrationStatus;

}

package com.caseanalitica.webservicegateway.app.rest.calibration;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationDue;
import com.caseanalitica.webservicegateway.infra.gateway.CalibrationGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/calibration-due")
public class CalibrationDueApi {

    private final CalibrationGateway calibrationGateway;

    @GetMapping("/month")
    public ResponseEntity<ApiResponse<CalibrationDue>> getCalibrationDueInCurrentMonth(
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize
    ) {
        var response = calibrationGateway.getCalibrationDueInCurrentMonth(pageSize);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @GetMapping("/year")
    public ResponseEntity<ApiResponse<CalibrationDue>> getCalibrationDueInCurrentYear(
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize
    ) {
        var response = calibrationGateway.getCalibrationDueInCurrentYear(pageSize);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

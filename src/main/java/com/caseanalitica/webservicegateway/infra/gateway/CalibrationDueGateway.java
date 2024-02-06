package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationControl;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationDue;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationProgram;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "calibration-due-api", url = "${api.url.calibration}")
public interface CalibrationDueGateway {

    @GetMapping("/api/calibration-due/calibrations-due-month")
    ApiResponse<CalibrationDue> getCalibrationDueInCurrentMonth(@RequestParam Integer pageSize);

    @GetMapping("/api/calibration-due/calibrations-due-year")
    ApiResponse<CalibrationDue> getCalibrationDueInCurrentYear(@RequestParam Integer pageSize);

}

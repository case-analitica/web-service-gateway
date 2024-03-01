package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationControl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "calibration-control-api", url = "${api.url.calibration}")
public interface CalibrationControlGateway {

    @GetMapping("/api/calibration-control")
    ApiResponse<CalibrationControl> getAllCalibrationsControl(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/calibration-control/{id}")
    ApiResponse<CalibrationControl> getOneCalibrationControl(@PathVariable Long id);

    @PostMapping("/api/calibration-control")
    ApiResponse<CalibrationControl> saveCalibrationControl(CalibrationControl calibrationControl);

    @PatchMapping("/api/calibration-control")
    ApiResponse<CalibrationControl> updateCalibrationControl(CalibrationControl calibrationControl);

    @DeleteMapping("/api/calibration-control/{id}")
    ApiResponse<CalibrationControl> deleteCalibrationControl(@PathVariable Long id);

}

package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationProgram;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "calibration-program-api", url = "${api.url.calibration}")
public interface CalibrationProgramGateway {

    @GetMapping("/api/calibration-program")
    ApiResponse<CalibrationProgram> getAllCalibrationsProgram(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/calibration-program/{id}")
    ApiResponse<CalibrationProgram> getOneCalibrationProgram(@PathVariable Long id);

    @PostMapping("/api/calibration-program")
    ApiResponse<CalibrationProgram> saveCalibrationProgram(CalibrationProgram calibrationProgram);

    @PatchMapping("/api/calibration-program")
    ApiResponse<CalibrationProgram> updateCalibrationProgram(CalibrationProgram calibrationProgram);

    @DeleteMapping("/api/calibration-program/{id}")
    ApiResponse<CalibrationProgram> deleteCalibrationProgram(@PathVariable Long id);
}

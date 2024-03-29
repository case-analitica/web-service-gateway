package com.caseanalitica.webservicegateway.app.rest.calibration;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationControl;
import com.caseanalitica.webservicegateway.infra.gateway.CalibrationControlGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/calibration-control")
public class CalibrationControlApi {

    private final CalibrationControlGateway calibrationControlGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<CalibrationControl>> getAllCalibrationsControl(
            @RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
            @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
            @RequestParam(value = "direction", required = false, defaultValue = "ASC") String direction,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        var response = calibrationControlGateway.getAllCalibrationsControl(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CalibrationControl>> saveCalibrationControl(CalibrationControl calibrationControl) {
        var response = calibrationControlGateway.saveCalibrationControl(calibrationControl);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

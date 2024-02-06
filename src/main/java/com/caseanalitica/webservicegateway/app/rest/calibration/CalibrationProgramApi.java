package com.caseanalitica.webservicegateway.app.rest.calibration;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.calibration.CalibrationProgram;
import com.caseanalitica.webservicegateway.infra.gateway.CalibrationProgramGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/calibration-program")
public class CalibrationProgramApi {

    private final CalibrationProgramGateway calibrationProgramGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<CalibrationProgram>> getAllCalibrationsProgram(
            @RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
            @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
            @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        var response = calibrationProgramGateway.getAllCalibrationsProgram(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<CalibrationProgram>> createCalibrationProgram(@RequestBody CalibrationProgram calibrationProgram) {
        ApiResponse<CalibrationProgram> apiResponse = calibrationProgramGateway.saveCalibrationProgram(calibrationProgram);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<CalibrationProgram>> getOneCalibrationProgram(@PathVariable final Long id) {
        return new ResponseEntity<>(calibrationProgramGateway.getOneCalibrationProgram(id), HttpStatus.OK);
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<CalibrationProgram>> updateCalibrationProgram(@RequestBody final CalibrationProgram calibrationProgram) {
        return new ResponseEntity<>(calibrationProgramGateway.updateCalibrationProgram(calibrationProgram), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<CalibrationProgram>> deleteCalibrationProgram(@PathVariable final Long id) {
        return new ResponseEntity<>(calibrationProgramGateway.deleteCalibrationProgram(id), HttpStatus.OK);
    }


}

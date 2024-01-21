package com.caseanalitica.webservicegateway.app.rest.device;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.device.Device;
import com.caseanalitica.webservicegateway.infra.gateway.DeviceGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/device")
public class DeviceApi {

    private final DeviceGateway deviceGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<Device>> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
                                                             @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
                                                             @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                             @RequestParam(value = "sort", required = false, defaultValue = "model") String sort,
                                                             @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        var response = deviceGateway.getAllDevices(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Device>> getOneCustomer(@PathVariable final Long id) {
        var response = deviceGateway.getOneDevice(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Device>> saveDevice(Device device) {
        var response = deviceGateway.saveDevice(device);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Device>> updateDevice(@RequestBody final Device request) {
        var response = deviceGateway.updateDevice(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Device>> deleteDevice(@PathVariable final Long id) {
        var response = deviceGateway.deleteDevice(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

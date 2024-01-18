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

    @PostMapping
    public ResponseEntity<ApiResponse<Device>> saveCustomerDevice(Device device) {
        var response = deviceGateway.saveCustomerDevice(device);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

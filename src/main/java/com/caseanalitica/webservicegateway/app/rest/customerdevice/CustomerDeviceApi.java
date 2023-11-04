package com.caseanalitica.webservicegateway.app.rest.customerdevice;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerDeviceGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer-device")
public class CustomerDeviceApi {

    private final CustomerDeviceGateway customerDeviceGateway;

    public CustomerDeviceApi(CustomerDeviceGateway customerDeviceGateway) {
        this.customerDeviceGateway = customerDeviceGateway;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
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

        return new ResponseEntity<>(customerDeviceGateway.getAllDevices(map), HttpStatus.OK);
    }

}

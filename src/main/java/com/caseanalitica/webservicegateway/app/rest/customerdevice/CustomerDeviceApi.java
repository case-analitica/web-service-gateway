package com.caseanalitica.webservicegateway.app.rest.customerdevice;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customerdevice.CustomerDevice;
import com.caseanalitica.webservicegateway.app.dto.instrument.Instrument;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerDeviceGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/customer-device")
public class CustomerDeviceApi {

    private final CustomerDeviceGateway customerDeviceGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<CustomerDevice>> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
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

        var response = customerDeviceGateway.getAllDevices(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerDevice>> saveCustomerDevice(CustomerDevice customerDevice) {
        var response = customerDeviceGateway.saveCustomerDevice(customerDevice);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

package com.caseanalitica.webservicegateway.app.rest.customer;

import com.caseanalitica.webservicegateway.app.dto.ApiResponse;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer-api")
public class CustomerApi {

    private final CustomerGateway customerGateway;

    public CustomerApi(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @GetMapping("/customer")
    public ResponseEntity<ApiResponse> getAllCustomers(@RequestParam(value = "filterName", required = false) String filterName,
                                                    @RequestParam(value = "filterValue", required = false) String filterValue,
                                                    @RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "sort", required = false) String sort,
                                                    @RequestParam(value = "direction", required = false) String direction,
                                                    @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        return new ResponseEntity<>(customerGateway.getAllCustomers(map), HttpStatus.OK);
    }

}

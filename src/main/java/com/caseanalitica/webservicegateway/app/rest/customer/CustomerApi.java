package com.caseanalitica.webservicegateway.app.rest.customer;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    CustomerGateway customerGateway;

    @GetMapping
    public ResponseEntity<ApiResponse> getCustomers(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
                                                    @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
                                                    @RequestParam(value = "pageIndex", required = false, defaultValue = "0") Integer pageIndex,
                                                    @RequestParam(value = "sort", required = false, defaultValue = "nome") String sort,
                                                    @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> customerMap = new HashMap<>();
        customerMap.put("filterName", filterName);
        customerMap.put("filterValue", filterValue);
        customerMap.put("pageIndex", String.valueOf(pageIndex));
        customerMap.put("sort", sort);
        customerMap.put("direction", direction);
        customerMap.put("pageSize", String.valueOf(pageSize));

        return new ResponseEntity<>(customerGateway.getCustomers(customerMap), HttpStatus.OK);
    }


}

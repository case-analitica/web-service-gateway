package com.caseanalitica.webservicegateway.app.rest.customer;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customer.Address;
import com.caseanalitica.webservicegateway.app.dto.customer.Customer;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    CustomerGateway customerGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<Customer>> getCustomers(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
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

        var response = customerGateway.getCustomers(customerMap);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Customer>> getOneCustomer(@PathVariable final Long id) {
        var response = customerGateway.getOneCustomer(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Address>> createCustomerAddress(@RequestBody final Address request) {
        var response = customerGateway.createCustomerAddress(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Address>> updateCustomerAddress(@RequestBody final Address request) {
        var response = customerGateway.updateCustomerAddress(request);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Address>> deleteCustomer(@PathVariable final Long id) {
        var response = customerGateway.deleteCustomerAddress(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

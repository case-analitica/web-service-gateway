package com.caseanalitica.webservicegateway.app.rest.customer;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customer.AddressRequest;
import com.caseanalitica.webservicegateway.infra.gateway.CustomerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse> getOneCustomer(@PathVariable final Long id){
        return new ResponseEntity<>(customerGateway.getOneCustomer(id), HttpStatus.OK);
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse> createCustomerAddress(@RequestBody final AddressRequest request) {
        return new ResponseEntity<>(customerGateway.createCustomerAddress(request), HttpStatus.OK);
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse> updateCustomerAddress(@RequestBody final AddressRequest request) {
        return new ResponseEntity<>(customerGateway.updateCustomerAddress(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable final Long id){
        return new ResponseEntity<>(customerGateway.deleteCustomerAddress(id), HttpStatus.OK);
    }

}

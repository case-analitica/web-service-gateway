package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customer.Address;
import com.caseanalitica.webservicegateway.app.dto.customer.Customer;
import com.caseanalitica.webservicegateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "customer-api", url = "${api.url.customer}", configuration = FeignConfig.class)

public interface CustomerGateway {

    @GetMapping("/api/customer")
    ApiResponse<Customer> getCustomers(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/customer/{id}")
    ApiResponse<Customer> getOneCustomer(@PathVariable Long id);

    @PostMapping("/api/customer")
    ApiResponse<Address> createCustomerAddress(Address request);

    @PatchMapping("/api/customer")
    ApiResponse<Address> updateCustomerAddress(Address request);

    @DeleteMapping("/api/customer/{id}")
    ApiResponse<Address> deleteCustomerAddress(@PathVariable Long id);
}

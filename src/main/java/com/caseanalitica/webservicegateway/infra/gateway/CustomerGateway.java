package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customer.AddressRequest;
import com.caseanalitica.webservicegateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "customer-api", url = "${api.url.customer}", configuration = FeignConfig.class)

public interface CustomerGateway {

    @GetMapping("/api/customer")
    ApiResponse getCustomers(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/customer/{id}")
    ApiResponse getOneCustomer(@PathVariable Long id);

    @PostMapping("/api/customer")
    ApiResponse createCustomerAddress(AddressRequest request);

    @PatchMapping("/api/customer")
    ApiResponse updateCustomerAddress(AddressRequest request);

    @DeleteMapping("/api/customer/{id}")
    ApiResponse deleteCustomerAddress(@PathVariable Long id);
}

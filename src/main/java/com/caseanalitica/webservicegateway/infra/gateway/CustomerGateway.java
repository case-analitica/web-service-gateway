package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "customer-api", url = "${api.url.customer}")

public interface CustomerGateway {

    @GetMapping("/api/customer")
    ApiResponse getCustomers(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/customer/{id}")
    ApiResponse getOneCustomer(@PathVariable String id);

}

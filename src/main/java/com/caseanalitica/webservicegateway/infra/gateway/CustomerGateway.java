package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.webservicegateway.app.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "customer-api", url = "${api.url.customer}")
public interface CustomerGateway {

    @GetMapping("/api/customer")
    ApiResponse getAllCustomers(@SpringQueryMap Map<String, String> queryMap);

}

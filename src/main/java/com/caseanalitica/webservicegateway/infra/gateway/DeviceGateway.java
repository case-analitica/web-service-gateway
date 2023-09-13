package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "device-api", url = "${api.url.device}")
public interface DeviceGateway {

    @GetMapping("/api/device")
    ApiResponse getAllDevices(@SpringQueryMap Map<String, String> queryMap);

}

package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.device.Device;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "device-api", url = "${api.url.device}")
public interface DeviceGateway {

    @GetMapping("/api/device")
    ApiResponse<Device> getAllDevices(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/device")
    ApiResponse<Device> saveCustomerDevice(Device device);
}

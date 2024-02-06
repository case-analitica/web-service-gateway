package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.device.Device;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "device-api", url = "${api.url.device}")
public interface DeviceGateway {

    @GetMapping("/api/device")
    ApiResponse<Device> getAllDevices(@SpringQueryMap Map<String, String> queryMap);

    @GetMapping("/api/device/{id}")
    ApiResponse<Device> getOneDevice(@PathVariable Long id);

    @PostMapping("/api/device")
    ApiResponse<Device> saveDevice(Device device);

    @PatchMapping("/api/device")
    ApiResponse<Device> updateDevice(Device request);

    @DeleteMapping("/api/device/{id}")
    ApiResponse<Device> deleteDevice(@PathVariable Long id);
}

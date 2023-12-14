package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.customerdevice.CustomerDevice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "customer-device-api", url = "${api.url.customer-device}")
public interface CustomerDeviceGateway {

    @GetMapping("/api/customer-device")
    ApiResponse<CustomerDevice> getAllDevices(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/customer-device")
    ApiResponse<CustomerDevice> saveCustomerDevice(CustomerDevice customerDevice);
}

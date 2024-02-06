package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.standard.Standard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "standard-api", url = "${api.url.standard-instrument}")
public interface StandardGateway {

    @GetMapping("/api/standards")
    ApiResponse<Standard> getAllStandards(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/standards")
    ApiResponse<Standard> saveStandard(Standard standard);

    @GetMapping("/api/standards/{id}")
    ApiResponse<Standard> getOneStandard(@PathVariable Long id);

    @PatchMapping("/api/standards")
    ApiResponse<Standard> updateStandard(Standard request);

    @DeleteMapping("/api/standards/{id}")
    ApiResponse<Standard> deleteStandard(@PathVariable Long id);

}

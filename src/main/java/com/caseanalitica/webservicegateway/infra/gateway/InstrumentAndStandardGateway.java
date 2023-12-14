package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.instrument.Instrument;
import com.caseanalitica.webservicegateway.app.dto.standard.Standard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "standard-instrument-api", url = "${api.url.standard-instrument}")
public interface InstrumentAndStandardGateway {

    @GetMapping("/api/instruments")
    ApiResponse<Instrument> getAllInstruments(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/instruments")
    ApiResponse<Instrument> saveInstrument(Instrument instrument);

    @GetMapping("/api/standards")
    ApiResponse<Standard> getAllStandards(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/standards")
    ApiResponse<Standard> saveStandard(Standard standard);

}

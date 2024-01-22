package com.caseanalitica.webservicegateway.infra.gateway;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.instrument.Instrument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "instrument-api", url = "${api.url.standard-instrument}")
public interface InstrumentGateway {

    @GetMapping("/api/instruments")
    ApiResponse<Instrument> getAllInstruments(@SpringQueryMap Map<String, String> queryMap);

    @PostMapping("/api/instruments")
    ApiResponse<Instrument> saveInstrument(Instrument instrument);

    @GetMapping("/api/instruments/{id}")
    ApiResponse<Instrument> getOneInstrument(@PathVariable Long id);

    @PatchMapping("/api/instruments")
    ApiResponse<Instrument> updateInstrument(Instrument request);

    @DeleteMapping("/api/instruments/{id}")
    ApiResponse<Instrument> deleteInstrument(@PathVariable Long id);

}

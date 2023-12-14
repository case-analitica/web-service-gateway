package com.caseanalitica.webservicegateway.app.rest.standard;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.standard.Standard;
import com.caseanalitica.webservicegateway.infra.gateway.InstrumentAndStandardGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/standard")
public class StandardApi {

    private final InstrumentAndStandardGateway instrumentAndStandardGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<Standard>> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
                                                               @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
                                                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                               @RequestParam(value = "sort", required = false, defaultValue = "description") String sort,
                                                               @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        var response = instrumentAndStandardGateway.getAllStandards(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Standard>> saveStandard(Standard standard) {
        var response = instrumentAndStandardGateway.saveStandard(standard);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

}

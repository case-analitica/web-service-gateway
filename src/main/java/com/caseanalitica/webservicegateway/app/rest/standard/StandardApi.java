package com.caseanalitica.webservicegateway.app.rest.standard;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.standard.Standard;
import com.caseanalitica.webservicegateway.infra.gateway.StandardGateway;
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

    private final StandardGateway standardGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<Standard>> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
                                                               @RequestParam(value = "filterValue", required = false, defaultValue = "") String filterValue,
                                                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                               @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                                               @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        Map<String, String> map = new HashMap<>();
        map.put("filterName", filterName);
        map.put("filterValue", filterValue);
        map.put("page", String.valueOf(page));
        map.put("sort", sort);
        map.put("direction", direction);
        map.put("pageSize", String.valueOf(pageSize));

        var response = standardGateway.getAllStandards(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Standard>> saveStandard(Standard standard) {
        var response = standardGateway.saveStandard(standard);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Standard>> getOneCustomer(@PathVariable final Long id) {
        return new ResponseEntity<>(standardGateway.getOneStandard(id), HttpStatus.OK);
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Standard>> updateCustomerAddress(@RequestBody final Standard standard) {
        return new ResponseEntity<>(standardGateway.updateStandard(standard), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Standard>> deleteCustomerAddress(@PathVariable final Long id) {
        return new ResponseEntity<>(standardGateway.deleteStandard(id), HttpStatus.OK);
    }

}

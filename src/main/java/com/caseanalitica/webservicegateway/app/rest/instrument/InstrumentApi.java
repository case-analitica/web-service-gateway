package com.caseanalitica.webservicegateway.app.rest.instrument;

import com.caseanalitica.commons.ApiResponse;
import com.caseanalitica.webservicegateway.app.dto.instrument.Instrument;
import com.caseanalitica.webservicegateway.infra.gateway.InstrumentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/instrument")
public class InstrumentApi {

    private final InstrumentGateway instrumentGateway;

    @GetMapping
    public ResponseEntity<ApiResponse<Instrument>> getAllDevices(@RequestParam(value = "filterName", required = false, defaultValue = "") String filterName,
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

        var response = instrumentGateway.getAllInstruments(map);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instrument>> saveStandard(Instrument instrument) {
        var response = instrumentGateway.saveInstrument(instrument);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Instrument>> getOneCustomer(@PathVariable final Long id) {
        return new ResponseEntity<>(instrumentGateway.getOneInstrument(id), HttpStatus.OK);
    }

    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Instrument>> updateCustomerAddress(@RequestBody final Instrument instrument) {
        return new ResponseEntity<>(instrumentGateway.updateInstrument(instrument), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<ApiResponse<Instrument>> deleteCustomerAddress(@PathVariable final Long id) {
        return new ResponseEntity<>(instrumentGateway.deleteInstrument(id), HttpStatus.OK);
    }

}

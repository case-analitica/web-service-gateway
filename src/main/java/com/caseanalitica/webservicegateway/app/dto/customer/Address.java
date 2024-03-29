package com.caseanalitica.webservicegateway.app.dto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private Long id;
    private Long customerId;
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String country;
    private String cityId;
    private String city;
    private String state;
    private Boolean status;

}

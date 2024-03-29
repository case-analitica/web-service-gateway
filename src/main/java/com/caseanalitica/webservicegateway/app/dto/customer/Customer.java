package com.caseanalitica.webservicegateway.app.dto.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Customer {

    private String id;
    private String customerType;
    private String name;
    private String corporateName;
    private String cnpj;
    private String stateRegistration;
    private String cityRegistration;
    private String cpf;
    private String rg;
    private String birth;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private String active;
    private List<Contact> contacts;
    private List<Address> addresses;
    private List<Address> deliveryAddresses;

}

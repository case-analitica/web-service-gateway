package com.caseanalitica.webservicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceGatewayApplication.class, args);
    }

}

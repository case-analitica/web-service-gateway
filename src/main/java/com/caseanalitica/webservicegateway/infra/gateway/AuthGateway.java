package com.caseanalitica.webservicegateway.infra.gateway;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-api", url = "${api.url.auth}")
public interface AuthGateway {

    @PostMapping("/realms/caseanalitica/protocol/openid-connect/token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    String retrieveAuthToken(MultiValueMap<String, String> queryMap);

}

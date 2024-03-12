package com.caseanalitica.webservicegateway.app.auth;

import com.caseanalitica.webservicegateway.app.dto.auth.User;
import com.caseanalitica.webservicegateway.infra.gateway.AuthGateway;
import lombok.AllArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/token")
@RestController
public class TokenController {

    private AuthGateway authGateway;

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public String token(@RequestBody User user) {

        MultiValueMap<String, String> authMap = new LinkedMultiValueMap<>();
        authMap.add("client_id", user.clientId());
        authMap.add("username", user.username());
        authMap.add("password", user.password());
        authMap.add("grant_type", user.grantType());

        return authGateway.retrieveAuthToken(authMap);

    }

}

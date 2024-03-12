package com.caseanalitica.webservicegateway.app.dto.auth;

public record User(String password, String clientId, String grantType, String username){

}

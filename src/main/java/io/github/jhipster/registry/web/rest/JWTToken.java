package io.github.jhipster.registry.web.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 返回一个jsonweb token
 * Object to return as body in JWT Authentication
 */
public class JWTToken {
    /**
     * token
     */
    private String idToken;

    public JWTToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}

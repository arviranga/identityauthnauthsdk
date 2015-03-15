package com.arathika.identityauthnauth.api.rest;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TokenResponse {

    @XmlElement(name = "access_token")
    private String accessToken;

    @XmlElement(name = "token_type")
    private String tokenType;

    private String scope;

    @XmlElement(name = "expires_in")
    private Long expiresIn;

    @XmlElement(name = "refresh_token")
    private String refreshToken;

    @XmlElement(name = "id_token")
    private String idToken;

    @XmlElement(name = "code")
    private String code;

    @XmlElement(name = "nonce")
    private String nonce;

    @XmlElement(name = "error")
    private String errorString;

    @XmlElement(name = "error_description")
    private String errorDescription;

    @XmlElement(name = "error_uri")
    private String errorUri;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    /**
     * @return the errorUri
     */
    public String getErrorUri() {
        return errorUri;
    }

    /**
     * @param errorUri the errorUri to set
     */
    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }
}

package com.arathika.identityauthnauth.domain;

/**
 * Domain represents a realm or an organization and properties associated with the domain.
 * Will also have policies and permission required to read/write these properties.
 */
public interface Domain {

    String getName();
    
    
}

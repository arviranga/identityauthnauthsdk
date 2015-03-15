
package com.arathika.identityauthnauth.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;

@Consumes({"application/xml", "application/json"}) 
@Produces({"application/xml", "application/json"})
@Path("v1/authentication")
public interface IdentityAuthnAuth {

    @Path("token")
    @POST
    @Produces({APPLICATION_JSON})
    @Consumes({APPLICATION_FORM_URLENCODED})
    @ElementClass(response = TokenResponse.class)
    public Response tokenEndpoint(@Context final HttpHeaders headers,
        final MultivaluedMap<String, String> formData,
        @Context final HttpServletRequest request);
}

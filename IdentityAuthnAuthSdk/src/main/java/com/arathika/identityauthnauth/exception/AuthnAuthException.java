package com.arathika.identityauthnauth.exception;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.ws.rs.core.Response;

/**
 * Exception class to encapsulate error codes, HTTP response codes and localized messages.
 */
public final class AuthnAuthException extends Exception {

    private static Map<String, ResourceBundle> bundles = new HashMap<>();

    private static String RESOURCE_BUNDLE = "errorMessages";

    // To be initialized during construction
    protected ResourceBundle resourceBundle;
    private String errorCode;
    private String error;
    private String description;
    private Object[] params;
    private Response.Status responseStatus;
    private String hateoasUrl;

    /**
     * Creates an Identity & Access Management exception. It is a generic exception
     * to be extended by other components.
     *
     * @param errorCode Error code.
     */
    public AuthnAuthException(String errorCode) {
        init(errorCode);
    }

    /**
     * Creates an Identity & Access Management exception.
     *
     * @param errorCode Error code.
     * @param params Parameters for formatting the message string.
     */
    public AuthnAuthException(String errorCode, Object[] params) {
        this.params = params;
        init(errorCode);
    }

    /**
     * Creates an Identity & Access Management exception.
     *
     * @param errorCode Error code.
     * @param cause Root cause.
     */
    public AuthnAuthException(String errorCode, Throwable cause) {
        super(cause);
        init(errorCode);
    }

    /**
     * Creates an Identity & Access Management exception.
     *
     * @param errorCode Error code.
     * @param params Parameters for formatting the message string.
     * @param cause Root cause.
     */
    public AuthnAuthException(String errorCode, Object[] params, Throwable cause) {
        super(cause);
        this.params = params;
        init(errorCode);
    }
    
    protected final void init(String errorCode) {
        initResourceBundle();
        if (errorCode.indexOf('|') != -1) {
            String[] p = errorCode.split("\\|");
            params = new Object[p.length-1];
            this.errorCode = p[0];
            for (int i = 1; i < p.length; i++) {
                params[i-1] = p[i];
            }
        } else {
            this.errorCode = errorCode;
        }
        this.error = getErrorMessage();
        this.description = getLocalizedMessage(Locale.getDefault());
        this.responseStatus = getResponseStatus();
    }
    
    /**
     * Initialized resource bundle for the component
     */
    protected final void initResourceBundle() {
        resourceBundle = bundles.get(RESOURCE_BUNDLE);
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
            bundles.put(RESOURCE_BUNDLE, resourceBundle);
        }
    }
    
    public String getInitCode() {
        if (params == null) {
            return errorCode;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(errorCode);
        for (Object p : params) {
            sb.append('|').append(String.valueOf(p));
        }
        return sb.toString();
    }

    /**
     * Returns error code.
     *
     * @return error code.
     */
    public String getError() {
        return error;
    }

    /**
     * Returns exception message.
     *
     * @return exception message.
     */
    @Override
    public String getMessage() {
        return description;
    }
    
    /**
     * Returns HTTP response status code
     * 
     * @return 
     */
    public Response.Status getHttpStatusResponse() {
        if (responseStatus != null) {
            return responseStatus;
        }
       return Response.Status.UNAUTHORIZED;
    }
    
    public String getHateoasUrl() {
        return hateoasUrl;
    }
    
    private String getErrorMessage() {
        String msg = resourceBundle.getString(errorCode);
        int index;
        if ((index = msg.indexOf('|')) != -1) {
            msg = msg.substring(0, index);
        }
        return msg;
    }
    
    private Response.Status getResponseStatus() {
        Response.Status status = Response.Status.UNAUTHORIZED;
        try {
            String msg = resourceBundle.getString(errorCode + "_status");
            if (msg != null) {
                switch (msg) {
                    case "500":
                        status = Response.Status.INTERNAL_SERVER_ERROR;
                        break;
                    case "400":
                        status = Response.Status.BAD_REQUEST;
                        break;
                }
            }
        } catch (MissingResourceException mre) {
            // Ignore
        }
        return status;
    }
    
    /**
     * Returns localized exception message.
     *
     * @return localized exception message.
     */
    @Override
    public String getLocalizedMessage() {
        return description;
    }

    /**
     * Returns localized exception message.
     *
     * @param locale Locale of the message.
     * @return localized exception message.
     */
    public final String getLocalizedMessage(Locale locale) {
        String msg = resourceBundle.getString(errorCode);
        int index;
        if (((index = msg.indexOf('|')) != -1) && (index < msg.length())) {
            msg = msg.substring(index+1);
        }
        return params != null ? MessageFormat.format(msg, params) : msg;
    }
}

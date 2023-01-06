package org.example.config;

import io.restassured.http.Method;


public enum RequestMethod {

    /**
     * Delete.
     */
    DELETE (Method.DELETE),
    /**
     * Get.
     */
    GET (Method.GET),
    /**
     * Head.
     */
    HEAD (Method.HEAD),
    /**
     * Options.
     */
    OPTIONS (Method.OPTIONS),
    /**
     * Patch.
     */
    PATCH (Method.PATCH),
    /**
     * Post.
     */
    POST (Method.POST),
    /**
     * Put.
     */
    PUT (Method.PUT),
    /**
     * Trace.
     */
    TRACE (Method.TRACE);

    private final Method method;

    private RequestMethod (final Method method) {
        this.method = method;
    }

    /**
     * @author gabriel.mustata
     * @return the method
     */
    public Method getMethod () {
        return this.method;
    }
}

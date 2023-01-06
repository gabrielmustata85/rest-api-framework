package org.example.config;

public enum ContentType {

    /**
     * Any.
     */
    ANY ("*/*"),
    /**
     * <code>application/javascript</code>
     */
    APP_JS ("application/javascript"),
    /**
     * <code>application/json</code>
     */
    APP_JSON ("application/json"),
    /**
     * <code>application/xhtml+xml</code>
     */
    APP_XHTML ("application/xhtml+xml"),
    /**
     * <code>application/xml</code>
     */
    APP_XML ("application/xml"),
    /**
     * <code>application/octet-stream</code>
     */
    BINARY ("application/octet-stream"),
    /**
     * <code>text/html</code>
     */
    HTML ("text/html"),
    /**
     * <code>text/javascript</code>
     */
    TEXT_JS ("text/javascript"),
    /**
     * <code>text/json</code>
     */
    TEXT_JSON ("text/json"),
    /**
     * <code>text/plain</code>
     */
    TEXT_PLAIN ("text/plain"),
    /**
     * <code>text/xml</code>
     */
    TEXT_XML ("text/xml"),
    /**
     * <code>application/x-www-form-urlencoded</code>
     */
    URLENC ("application/x-www-form-urlencoded");

    private final String type;

    private ContentType (final String type) {
        this.type = type;
    }

    @Override
    public String toString () {
        return this.type;
    }
}

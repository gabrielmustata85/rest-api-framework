package org.example.requests;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestAttribute {


    public static RequestAttribute create () {
        return new RequestAttribute ();
    }


    public static RequestAttribute create (final String prefix, final String name, final String value) {
        return new RequestAttribute (prefix, name, value);
    }

    private String	name;
    private String	prefix;
    private Object	value;


    private RequestAttribute () {
        this (null, null, null);
    }


    public String name () {
        return this.name;
    }


    public RequestAttribute name (final String attrName) {
        this.name = attrName;
        return this;
    }

    public String prefix () {
        return this.prefix;
    }

    public RequestAttribute prefix (final String attrPrefix) {
        this.prefix = attrPrefix;
        return this;
    }


    public Object value () {
        return this.value;
    }


    public RequestAttribute value (final Object attrValue) {
        this.value = attrValue;
        return this;
    }
}

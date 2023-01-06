package org.example.requests;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class RequestElement {

    private final List<RequestAttribute> attributes;
    private final List<RequestElement> childs;
    private boolean display;
    private final List<RequestElement> list;
    private String name;
    private final Map<String, String> namespace;
    private RequestElement parent;
    private String prefix;
    private Object value;


    public static RequestElement create() {
        return new RequestElement();
    }

    public static RequestElement create(final String name) {
        return new RequestElement();
    }

    public static RequestElement create(final String prefix, final String name) {
        return new RequestElement(prefix, name);
    }


    /**
     * @author wasiq.bhamla
     * @since 20-Aug-2017 3:23:36 PM
     */
    private RequestElement() {
        this(null, null);
    }

    /**
     * @author wasiq.bhamla
     * @since 20-Aug-2017 3:23:40 PM
     * @param name
     */
    private RequestElement(final String name) {
        this(null, name);
    }

    /**
     * @author wasiq.bhamla
     * @since 20-Aug-2017 3:23:45 PM
     * @param prefix
     * @param name
     */
    private RequestElement(final String prefix, final String name) {
        this.childs = new ArrayList<>();
        this.list = new ArrayList<>();
        this.attributes = new ArrayList<>();
        this.display = true;
        this.prefix = prefix;
        this.name = name;
        this.namespace = new HashMap<>();
    }

    /**
     * @author wasiq.bhamla
     * @since 20-Aug-2017 3:23:53 PM
     * @param attribute
     * @return instance
     */
    public RequestElement addAttribute(final RequestAttribute attribute) {
        this.attributes.add(attribute);
        return this;
    }

    /**
     * @author wasiq.bhamla
     * @since 20-Aug-2017 3:27:32 PM
     * @param element
     * @return instance
     */
    public RequestElement addElement(final RequestElement element) {
        this.list.add(element);
        return this;
    }


    public List<RequestAttribute> attributes() {
        return this.attributes;
    }


    public List<RequestElement> childs() {
        return this.childs;
    }


    public boolean display() {
        return this.display;
    }

    public RequestElement display(final boolean shouldDisplay) {
        this.display = shouldDisplay;
        return this;
    }


    public RequestElement getChild(final String childName) {
        for (final RequestElement child : this.childs) {
            if (child.name()
                    .equalsIgnoreCase(childName)) {
                return child;
            }
        }
        return null;
    }


    public List<RequestElement> list() {
        return this.list;
    }


    public String name() {
        return this.name;
    }


    public RequestElement name(final String elementName) {
        this.name = elementName;
        return this;
    }


    public RequestElement namespace(final String ns, final String uri) {
        if (!this.namespace.containsKey(ns)) {
            this.namespace.put(ns, uri);
        }
        return this;
    }


    public Map<String, String> namespaces() {
        return this.namespace;
    }

    public RequestElement parent() {
        return this.parent;
    }

    public RequestElement parent(final RequestElement elementParent) {
        if (this.parent == null) {
            this.parent = elementParent;
        }
        if (!elementParent.childs()
                .contains(this)) {
            elementParent.addChild(this);
        }
        return this;
    }


    public String prefix() {
        return this.prefix;
    }

    public RequestElement prefix(final String elementPrefix) {
        this.prefix = elementPrefix;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T value() {
        return (T) this.value;
    }

    public <T> RequestElement value(final T elementValue) {
        this.value = elementValue;
        return display(this.value != null);
    }

    private RequestElement addChild(final RequestElement child) {
        this.childs.add(child);
        if (child.parent() == null || !child.parent()
                .equals(this)) {
            child.parent(this);
        }
        return this;
    }
}

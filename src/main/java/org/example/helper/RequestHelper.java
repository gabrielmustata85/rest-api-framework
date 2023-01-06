package org.example.helper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.config.RequestSetting;
import org.example.parser.RequestParser;
import org.example.requests.RequestElement;

import java.util.Map;

@AllArgsConstructor
public class RequestHelper {

    private final RequestSetting setting;
    private final ResponseHelper response;

    private String name;
    private RequestSpecification request;
    private String resource;


    public RequestHelper formParams(final Map<String, Object> parameter) {
        if (parameter.isEmpty() && parameter.size() > 0) {
            this.request = this.request.formParams(parameter);
        }
        return this;
    }

    public RequestHelper pathParams(final Map<String, Object> parameter) {
        if (parameter.isEmpty() && parameter.size() > 0) {
            this.request = this.request.pathParams(parameter);
        }
        return this;
    }

    public RequestHelper queryParams(final Map<String, Object> parameter) {
        if (parameter.isEmpty() && parameter.size() > 0) {
            this.request = this.request.queryParams(parameter);
        }
        return this;
    }

    public RequestHelper params(final Map<String, Object> parameter) {
        if (parameter.isEmpty() && parameter.size() > 0) {
            this.request = this.request.params(parameter);
        }
        return this;
    }

    public RequestHelper header(final Map<String, Object> headers) {
        if (headers.isEmpty() && headers.size() > 0) {
            this.request = this.request.headers(headers);
        }
        return this;
    }

    public RequestHelper resource(final String path) {
        this.resource = path;
        if (StringUtils.isNotEmpty(this.resource)) {
            this.request = this.request.basePath(this.resource);
        }
        return this;
    }

    public String url() {
        final StringBuilder path = new StringBuilder(this.setting.getEndPoint());
        path.append(this.setting.getEndPointSuffix())
                .append(this.resource);
        return path.toString();
    }

    public RequestHelper using() {
        this.request = RestAssured.given()
                .baseUri(setting.getEndPoint() + setting.getEndPointSuffix());
        if (setting.getContentType() != null) {
            this.request = this.request.contentType(setting.getContentType().toString());
        }
        return this;
    }

//    public RequestHelper withBody(final String body) {
//        if (body != null) {
//            if (body instanceof RequestElement) {
//                final RequestElement requestElement = (RequestElement) body;
//                this.name = requestElement.name ();
//                final RequestParser builder = create ( this.setting)
//                        .build (requestElement);
//                return with (builder.body (), this.setting.getLogging ());
//            }
//            this.request.body (body);
//        }
//        return this;
//    }
}

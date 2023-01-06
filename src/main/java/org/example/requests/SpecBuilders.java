package org.example.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {

    public static RequestSpecification request() {
        RequestSpecification request = new RequestSpecBuilder()
                .setBaseUri("https://www.automationexercise.com/")
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        return request;
    }

    public static ResponseSpecification response() {
        ResponseSpecification response = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
        return response;
    }


}

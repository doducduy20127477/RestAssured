package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class RequestSpecificationExample {
    @BeforeClass
    public void beforeClass() {
//        requestSpecification = with().
//                baseUri("https://api.postman.com").
//                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
//                log().all();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
                log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();
    }

    @org.testng.annotations.Test
    public void queryTest() {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(RestAssured.requestSpecification);
        System.out.println(queryableRequestSpecification.getBaseUri());
        System.out.println(queryableRequestSpecification.getHeaders());
    }
    @org.testng.annotations.Test
    public void validate_status_code() {
        Response response = get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), equalTo(200));

    }
    @org.testng.annotations.Test
    public void validate_response_body() {
        Response response = get("/workspaces").then().log().all().extract().response();
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("workspaces[0].name"), equalTo("My Workspace"));

    }
}

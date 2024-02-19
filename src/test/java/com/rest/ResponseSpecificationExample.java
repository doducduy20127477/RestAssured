package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecificationExample {
    @BeforeClass
    public void beforeClass() {
        // =================REQUEST=================
//        requestSpecification = with().
//                baseUri("https://api.postman.com").
//                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
//                log().all();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
                log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();

        // =================RESPONSE=================
//        responseSpecification = RestAssured.expect().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                log().all();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @org.testng.annotations.Test
    public void validate_status_code() {
        get("/workspaces");
    }
    @org.testng.annotations.Test
    public void validate_response_body() {
        Response response = get("/workspaces").then().extract().response();
        assertThat(response.path("workspaces[0].name"), equalTo("My Workspace"));

    }
}

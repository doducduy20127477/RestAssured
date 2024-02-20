package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class RequestPayloadAsJsonArray {
    @BeforeClass
    public void beforeClass() {
        // =================REQUEST=================
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                addHeader("x-mock-match-request-body", "true").
//                setConfig(config.encoderConfig(EncoderConfig.encoderConfig()
//                        .appendDefaultContentCharsetToContentTypeIfUndefined(false))).
//                setContentType(ContentType.JSON).
                setContentType("application/json;charset=utf-8").
                log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();

        // =================RESPONSE=================

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @org.testng.annotations.Test
    public void validate_post_request_payload_json_array_as_list() {
        HashMap<String, String> obj5001 = new HashMap<String, String>();
        obj5001.put("id", "5001");
        obj5001.put("type", "None");

        HashMap<String, String> obj5002 = new HashMap<String, String>();
        obj5002.put("id", "5002");
        obj5002.put("type", "Glazed");

        List<HashMap<String, String>> jsonList = new ArrayList<HashMap<String, String>>();
        jsonList.add(obj5001);
        jsonList.add(obj5002);

        given().
                body(jsonList).
        when().
                post("/post").
        then().
            assertThat().
            body("msg", equalTo("Success"));
    }

}

package com.rest;


import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class AutomateHeaders {
    @org.testng.annotations.Test
    public void multiple_headers() {
        Header header = new Header("header", "value1");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");

        given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                header(header).
                header(matchHeader).

        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
    @org.testng.annotations.Test
    public void multiple_headers_using_headers() {
        Header header = new Header("header", "value2");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");

        Headers headers = new Headers(header, matchHeader);

        given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
    @org.testng.annotations.Test
    public void multiple_headers_using_map() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header","value2");
        headers.put("x-mock-match-request-headers","header");

        given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
    @org.testng.annotations.Test
    public void multi_value_header_in_the_request() {
        Header header1 = new Header("multiValueHeader", "value1");
        Header header2 = new Header("multiValueHeader", "value2");

        Headers headers = new Headers(header1, header2);

        given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
                log().headers().
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @org.testng.annotations.Test
    public void assert_response_headers() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header","value1");
        headers.put("x-mock-match-request-headers","header");

        given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                headers(
                        "responseHeader", "resValue1",
                        "X-RateLimit-Limit", "120"
                )
        ;
    }
    @org.testng.annotations.Test
    public void extract_response_headers() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header","value1");
        headers.put("x-mock-match-request-headers","header");

        Headers extractedHeaders = given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                extract().
                headers();
        ;

        for ( Header header : extractedHeaders ) {
            System.out.print("header name: " + header.getName() + ", ");
            System.out.println("header value: " + header.getValue());
        }

//        System.out.println("header name= " + extractedHeaders.get("responseHeader").getName());
//        System.out.println("header value= " + extractedHeaders.get("responseHeader").getValue());
//        System.out.println("header value= " + extractedHeaders.getValue("responseHeader"));
    }
    @org.testng.annotations.Test
    public void extract_multivalue_response_headers() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header","value1");
        headers.put("x-mock-match-request-headers","header");

        Headers extractedHeaders = given().
                baseUri("https://39b47b36-cff3-431d-aa51-39dde8c6f368.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                extract().
                headers();
        ;

        List<String> values = extractedHeaders.getValues("multiValueHeader");
        System.out.println(values);
//        for ( String value : values ) {
//            System.out.println(value);
//        }
    }


}

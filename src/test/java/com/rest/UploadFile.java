package com.rest;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadFile {
    @Test
    public void upload_file_multipart_form_data() {
        String attributes = "{\n" +
                "    \"name\": \"temp.txt\",\n" +
                "    \"parent\": {\n" +
                "        \"id\": \"123456\"\n" +
                "    }\n" +
                "}";

        given().
                baseUri("https://postman-echo.com").
                multiPart("file", new File("temp.txt")).
                multiPart("attributes", attributes, "application/json").
                log().all().
        when().
                post("/post").
        then().
                log().all().
                assertThat().
                statusCode(200);

    }

}

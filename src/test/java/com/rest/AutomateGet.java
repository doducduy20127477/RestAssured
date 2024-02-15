package com.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AutomateGet {
    @Test
    public void extract_response() {
        Response res = given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().response();
        System.out.println("response = " + res.asString());
    }

    @Test
    public void extract_single_value_from_response() {
        Response res = given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                extract().response();

//        JsonPath jsonPath = new JsonPath(res.asString());
//        System.out.println("workspace name = " + jsonPath.getString("workspaces[0].name"));

        System.out.println("workspace name = " + JsonPath.from(res.asString()).getString("workspaces[0].name"));

//        System.out.println("workspace name = " + res.path("workspaces[0].name"));
    }

    @Test
    public void hamcrest_assert_on_extracted_response() {
        String name = given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                extract().response().path("workspaces[0].name");

        System.out.println("workspace name = " + name);
//        assertThat(name, equalTo("My Workspace"));
        Assert.assertEquals(name, "My Workspace");

    }

    @org.testng.annotations.Test
    public void validate_response_body_hamcrest_learnings() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                body("workspaces.name", contains("My Workspace", "My Workspace2", "Team Workspace"),
//                        "workspaces.name", containsInAnyOrder("My Workspace2", "My Workspace", "Team Workspace")
                        "workspaces.name", is(not(empty())),
                        "workspaces.name", hasSize(3),
                        "workspaces[0]", hasKey("id"),
                        "workspaces[0]", hasValue("My Workspace"),
                        "workspaces[0]", hasEntry("id", "2c453a92-3b4d-4f6e-8946-74f259357181"),
                        "workspaces[0]", not(equalTo(Collections.EMPTY_MAP)),
                        "workspaces[0].name", allOf(startsWith("My"), containsString("Workspace"))
                        );
    }
}

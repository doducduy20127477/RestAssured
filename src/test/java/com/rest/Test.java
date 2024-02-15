package com.rest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test {
    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "PMAK-65c09590f839c300013706f2-6a63306d868a798ec0524e4c96a7826f16").
        when().
                get("/workspaces").
        then().
            log().all(). // failure assertion, not print response body
            assertThat().
            statusCode(200).
            body("workspaces.name", hasItems("Team Workspace", "My Workspace", "My Workspace2"),
                            "workspaces.type", hasItems("team", "personal", "personal"),
                            "workspaces[0].name", equalTo("My Workspace"),
                            "workspaces[0].name", is(equalTo("My Workspace")),
                            "workspaces.size()", is(equalTo(3)),
                            "workspaces.name", hasItem("Team Workspace"));
    }


}

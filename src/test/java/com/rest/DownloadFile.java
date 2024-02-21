package com.rest;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class DownloadFile {
    @Test
    public void download_file() throws IOException {

        byte[] bytes = given().
                baseUri("https://raw.githubusercontent.com").

                log().all().
        when().
                post("/appium/appium/master/packages/appium/sample-code/apps/ApiDemos-debug.apk").
        then().
                log().all().
                extract().
                response().asByteArray();

        OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
        os.write(bytes);
        os.close();

    }

}

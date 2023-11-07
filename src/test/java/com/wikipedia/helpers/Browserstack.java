package com.wikipedia.helpers;

import com.wikipedia.drivers.BrowserStackDriver;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack extends BrowserStackDriver {
    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfig.getUsername(), browserstackConfig.getPassword())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
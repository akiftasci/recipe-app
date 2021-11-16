package com.abn.recipes.automatedTests;

import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class EndpointTest {

    /*
    These test needs to be run with application running.
     */
    @Test
    public void restassured() {
        JSONObject requParam = new JSONObject();
        requParam.put("username", "akiftasci");
        requParam.put("password", "empty");
        given().body(requParam).when().post("http://localhost:8080/authentication").then().assertThat().statusCode(200);
//        final Response response = RestAssured.get("http://localhost:8080/authentication");
//        Assertions.assertThat(response.getStatusCode() == 200);
//        Assertions.assertThat(response.getBody().print().equals("on air"));

    }
}

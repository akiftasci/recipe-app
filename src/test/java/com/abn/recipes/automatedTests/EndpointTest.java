package com.abn.recipes.automatedTests;

import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class EndpointTest {

    @Test
    public void restassured() {
        given().when().get("http://localhost:8080/authentication").then().assertThat().statusCode(200);
        given().when().get("http://localhost:8080/authentication").then().body(containsString("on air"));
        JSONObject requParam = new JSONObject();
        requParam.put("username", "akiftasci");
        requParam.put("password", "abnamro");
        given().body(requParam).when().post("http://localhost:8080/authentication").then().assertThat().statusCode(200);
//        final Response response = RestAssured.get("http://localhost:8080/authentication");
//        Assertions.assertThat(response.getStatusCode() == 200);
//        Assertions.assertThat(response.getBody().print().equals("on air"));

    }
}

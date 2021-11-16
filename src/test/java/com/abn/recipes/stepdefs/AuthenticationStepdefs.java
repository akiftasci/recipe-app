package com.abn.recipes.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;


public class AuthenticationStepdefs {
    String BASE_URL = "localhost:8080";
    JSONObject requParam = new JSONObject();
    final RequestSpecification request = RestAssured.given();

    @Given("The user is on the authentication page")
    public void theUserIsOnTheMainPage() {

        request.when()
            .post("http://localhost:8080/authentication").then().assertThat().statusCode(403);

    }

    @When("the user puts username")
    public void theUserPutsUsername() {
        requParam.put("username", "akiftasci");
    }

    @And("the user puts in the password")
    public void theUserPutsInThePassword() {
        requParam.put("password", "abnamro");

    }

    @Then("the user should be able to generate token with credentials")
    public void theUserShouldBeLoggedIn() {
        final Response response = request.body(requParam).when()
            .post("http://localhost:8080/authentication");
        final String jsonString = response.asString();
        Assertions.assertTrue(jsonString.length() > 0);
    }

}

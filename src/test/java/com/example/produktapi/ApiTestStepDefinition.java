package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class ApiTestStepDefinition {

    private static RequestSpecification request;

    private static Response response;

    @When("Given url")
    public void getEndPoint() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/my-endpoint";
        request = given();
        response =request.request(Method.GET,"");
    }
    @Then("Status for http request is {int}")
    public void checkEndPoint(Integer expectedcode) {
        int actualcode =response.getStatusCode();
        Assertions.assertEquals(expectedcode,actualcode);

    }
    @Given("the application is running")
    public void the_application_is_running() {

    }
    @When("the client requests GET \\/products\\/categories")
    public void the_client_requests_get_products_categories() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products/categories";
        request = given();
        response = request.request(Method.GET, "");
    }
    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        int actualStatus = response.getStatusCode();
        Assertions.assertEquals(expectedStatus,actualStatus);
    }




}

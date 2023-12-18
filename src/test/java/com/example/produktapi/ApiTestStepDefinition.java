package com.example.produktapi;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.config.JsonPathConfig;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.path.json.config.JsonPathConfig.*;
import static javax.swing.Action.DEFAULT;
import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

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
        List<String> categories = response.jsonPath().getList(".", String.class);

        // Print or log the available categories
        System.out.println("Available Categories: " + categories);
        response.then().assertThat().contentType(ContentType.JSON);
    }
    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        int actualStatus = response.getStatusCode();
        Assertions.assertEquals(expectedStatus,actualStatus);
    }
    @Then("the response content should contain the following categories:")
    public void the_response_content_should_contain_the_following_categories(List<String> expectedCategories) {
        response.then().body("size()", equalTo(expectedCategories.size()));

        List<String> actualCategories = response.jsonPath().getList(".", String.class);
        System.out.println(expectedCategories.size());
        System.out.println(actualCategories);
        System.out.println(expectedCategories);
        assertTrue(actualCategories.containsAll(expectedCategories));

    }








}

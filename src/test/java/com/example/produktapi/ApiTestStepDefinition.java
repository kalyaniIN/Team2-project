package com.example.produktapi;


import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import static junit.framework.TestCase.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class ApiTestStepDefinition {

    private static RequestSpecification request;

    private static Response response;

    //Uma
    @When("Given endpointurl")
    public void getEndPoint() {

        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/my-endpoint";
        request = given();
        response =request.request(Method.GET,"");
    }

    //Uma
    @Then("Status for http request is {int}")
    public void checkEndPoint(Integer expectedcode) {

        int actualcode =response.getStatusCode();
        Assertions.assertEquals(expectedcode,actualcode);
    }

    //Uma
    @Then("ContentType is text")
    public void body_is() {

        response.then().assertThat().contentType(ContentType.TEXT);


    }

    //Uma
    @Then("body is {string}")
    public void body_is(String strRes) {
        ResponseBody expected = response.getBody();
        System.out.println(expected.asString());
        Assertions.assertEquals(expected.asString(),strRes);

    }

    //Uma
    @When("Given producturl")
    public void given_producturl() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products";
        request = given();
        response =request.request(Method.GET,"");
    }

    //Uma
    @Then("contentType is JSON")
    public void content_type_is_json() {
        response.then().assertThat().contentType(ContentType.JSON);
    }

    //Uma
    @Then("verify data in the body")
    public void verify_data_in_the_body() {

        response.then().assertThat().body("category[0]",equalTo("men's clothing"));
    }
    //Faisal Farman
    @When("Given product by category url")
    public void given_product_by_category_url() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products/categories/jewelery";
        request = given();
        response =request.request(Method.GET,"");
    }

    //Kalyani
    @Given("the application is running")
    public void the_application_is_running() {

    }

    //Kalyani
    @When("the client requests GET \\/products\\/categories")
    public void the_client_requests_get_products_categories() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products/categories";
        request = given();
        response = request.request(Method.GET, "");
        List<String> categories = response.jsonPath().getList(".", String.class);


    }

    //Kalyani
    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        int actualStatus = response.getStatusCode();
        Assertions.assertEquals(expectedStatus,actualStatus);
    }

    //Kalyani
    @Then("the response content should contain the following categories:")
    public void the_response_content_should_contain_the_following_categories(List<String> expectedCategories) {
        response.then().body("size()", equalTo(expectedCategories.size()));

        List<String> actualCategories = response.jsonPath().getList(".", String.class);
        System.out.println(expectedCategories.size());
        System.out.println(actualCategories);
        System.out.println(expectedCategories);
        assertTrue(actualCategories.containsAll(expectedCategories));

    }

    //Faisal Farman
    @Then("verify category in the body")
    public void verify_category_in_the_body() {
        response.then().assertThat().body("category[0]",equalTo("jewelery"));
        response.then().assertThat().body("category[1]",equalTo("jewelery"));
        response.then().assertThat().body("category[2]",equalTo("jewelery"));
        response.then().assertThat().body("category[3]",equalTo("jewelery"));
    }

  // Suzana
    @When("Given product ID url")
    public void given_product_id_url() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products/1";
        request = given();
        response =request.request(Method.GET,"");
    }
 // Suzana
    @Then("Status for request should be {int}")
    public void status_for_request_should_be(Integer expectedStatuscode) {
      int actualCode = response.getStatusCode();
        Assertions.assertEquals(expectedStatuscode,actualCode);
        System.out.println(" The system code is:" + actualCode);
    }
 // Suzana
    @Then("Verify data in productID body")
    public void verify_data_in_product_id_body() {
        response.then().assertThat().body("description",equalTo("Fin väska me plats för dator"));
    }
}

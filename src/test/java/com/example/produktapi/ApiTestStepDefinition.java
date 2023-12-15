package com.example.produktapi;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

public class ApiTestStepDefinition {

    private static RequestSpecification request;

    private static Response response;

    @When("Given endpointurl")
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

    @Then("ContentType is text")
    public void body_is() {

        response.then().assertThat().contentType(ContentType.TEXT);


    }

    @When("Given producturl")
    public void given_producturl() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products";
        request = given();
        response =request.request(Method.GET,"");
    }

    @Then("contentType is JSON")
    public void content_type_is_json() {
        response.then().assertThat().contentType(ContentType.JSON);
    }


}

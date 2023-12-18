package com.example.produktapi;
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
import static org.hamcrest.Matchers.equalTo;

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

    @Then("body is {string}")
    public void body_is(String strRes) {
        ResponseBody expected = response.getBody();
        System.out.println(expected.asString());
        Assertions.assertEquals(expected.asString(),strRes);

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

    @Then("verify data in the body")
    public void verify_data_in_the_body() {

        response.then().assertThat().body("category[0]",equalTo("men's clothing"));

    }
    @When("Given product ID url")
    public void given_product_id_url() {
        baseURI="https://produktapi-6ef53ba8f2f2.herokuapp.com/products/1";
        request = given();
        response =request.request(Method.GET,"");
    }
    @Then("Status for request should be {int}")
    public void status_for_request_should_be(Integer expectedStatuscode) {
      int actualCode = response.getStatusCode();
        Assertions.assertEquals(expectedStatuscode,actualCode);
        System.out.println(" The system code is:" + actualCode);
    }
    @Then("Verify data in productID body")
    public void verify_data_in_product_id_body() {
        response.then().assertThat().body("description",equalTo("Fin väska me plats för dator"));
    }
}

package com.example.produktapi;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SystemTestStepDefinition {

    static WebDriver d ;

    @BeforeAll
    public static void setup(){
        d =new FirefoxDriver();
    }

    @Given("url is")
    public void url_is( String url) {
                  d.get(url);
        }


    @Then("Title is")
    public void title_is() {

    }

}

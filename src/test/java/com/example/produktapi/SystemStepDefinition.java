package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SystemStepDefinition {

    static WebDriver driver ;




    @Given("website is available")
    public void website_is_available() {
        driver =new FirefoxDriver();
    }
    @When("the user visits the website")
    public void the_user_visits_the_website() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }
    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle,"The title is not correct");
        driver.quit();
    }

    @When("user clicks on Shop")
    public void user_clicks_on_shop() {
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();
    }
    @When("wait for {int} millisec")
    public void user_waits_for_sec(Integer int1) {
        try {
            Thread.sleep(int1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
    @When("user click on jewelery")
    public void user_click_on_jewelery() {
        WebElement jewelery= driver.findElement(By.linkText("Jewelery"));
        jewelery.click();
    }
    @Then("verify the number of product is {int}")
    public void verify_the_number_of_product_is(Integer int1) {
        List<WebElement> items= driver.findElements(By.className("col"));
        Assertions.assertEquals(int1,items.size());
    }


    @When("user click on women's clothing")
    public void user_click_on_women_s_clothing() {
        WebElement cloth= driver.findElement(By.linkText("Women's clothing"));
        cloth.click();
    }

    @When("user click on electronics")
    public void userClickOnElectronics() {
        //Go to Electronics
        driver.findElement(By.linkText("Electronics")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    
   

  




}

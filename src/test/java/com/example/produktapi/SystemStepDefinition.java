package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
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
        //driver.quit();
    }

    @When("user clicks on Shop")
    public void userClicksOnShop() {
        //Go to shop
        driver.findElement(By.linkText("Shop")).click();
    }

    @When("wait for {int} millisec")
    public void waitForMillisec(int expectedMillisec) {
        //wait
        try {
            Thread.sleep(expectedMillisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user click on electronics")
    public void userClickOnElectronics() {
        //Go to Electronics
        driver.findElement(By.linkText("Electronics")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Then("verify the number of product is {int}")
    public void verifyTheNumberOfProductIs(int expectedNumberOfProduct) {
        //verify the number of products displayed in jewelery page
        int numberOfElectronicsProduct = driver.findElements(By.className("col")).size();
        Assertions.assertEquals(expectedNumberOfProduct,numberOfElectronicsProduct);
    }

    @When("Get the number of product in the checkout")
    public void getTheNumberOfProductInTheCheckout() {
        int numberOfTheProductInTheCart;
        var gettingNumberOfTheProductInTheCart = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();
        //Check if the cart was empty or not, if empty then setting value to 0.
        if(Objects.equals(gettingNumberOfTheProductInTheCart, "")) {
            numberOfTheProductInTheCart = 0;
        }
        else {
            //If the cart is not empty then parsing the string value to integer.
            numberOfTheProductInTheCart = Integer.parseInt(gettingNumberOfTheProductInTheCart);
        }
        //increasing the product number by 1 for later assert.
        int newNumberOfTheProductInTheCart = numberOfTheProductInTheCart + 1;
    }
    @When("User click on Add to cart")
    public void user_click_on_add_to_cart() {
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/button")).click();

    }

    @When("Get the number of product in the checkout after adding a product")
    public void getTheNumberOfProductInTheCheckoutAfterAddingAProduct() {
        //Getting number of product to the cart after adding a new product
        var gettingNumberOfTheProductAfterAddingANew = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();
        //Parsing the value from string to Int.
        int numberOfTheProductInTheCartAfterAddingANew = Integer.parseInt(gettingNumberOfTheProductAfterAddingANew);
    }

    @Then("Product will be added to the checkout")
    public void product_will_be_added_to_the_checkout() {

        // Verify that the product is added to the checkout.
        //Assertions.assertEquals(newNumberOfTheProductInTheCart,numberOfTheProductInTheCartAfterAddingANew );

    }
}

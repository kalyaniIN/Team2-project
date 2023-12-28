package com.example.produktapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.Objects;

public class SeleniumTestCases {
    private static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new FirefoxDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

    }
    @Test
    void testAllProductsDisplayed() {

        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
        WebElement allLink = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/a"));
        allLink.click();

        // Find all product elements on the page
//        List<WebElement> productElements = driver.findElements(By.className("nav-link px-2 link-body-emphasis"));
//
//        // Check that at least one product is displayed
//        Assertions.assertTrue(productElements.isEmpty(), "No products found on the page");
    }
    @Test
    void goToElectronicsAndCheckNumberOfProduct(){
        //Go to shop
        driver.findElement(By.linkText("Shop")).click();
        //wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Go to Electronics
        driver.findElement(By.linkText("Electronics")).click();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //verify the number of products displayed in jewelery page
        int numberOfElectronicsProduct = driver.findElements(By.className("col")).size();
        Assertions.assertEquals(6,numberOfElectronicsProduct);

    }

    @Test
    void addElectronicsProductAndCheckThatItIsAddedToTheCheckOut(){
        //Go to Shop
        driver.findElement(By.linkText("Shop")).click();
        //wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Go to Electronics page
        driver.findElement(By.linkText("Electronics")).click();

        //Save the number of the product in the Cart for later assert.
        var gettingNumberOfTheProductInTheCart = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();

        int numberOfTheProductInTheCart;
        //Check if the cart was empty or not, if empty then setting value to 0.
        if(Objects.equals(gettingNumberOfTheProductInTheCart, "")) {
            numberOfTheProductInTheCart = 0;
        }
        else {
            //If the cart is not empty then parsing the string value to integer.
            numberOfTheProductInTheCart = Integer.parseInt(gettingNumberOfTheProductInTheCart);
        }
        //increasing the product number by 1 for later assert and saving in a variable.
        int newNumberOfTheProductInTheCart = numberOfTheProductInTheCart + 1;

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();
        //Getting number of product to the cart after adding a new product
        var gettingNumberOfTheProductAfterAddingANew = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();
        //Parsing the value from string to Int.
        int numberOfTheProductInTheCartAfterAddingANew = Integer.parseInt(gettingNumberOfTheProductAfterAddingANew);
        // Verify that the product is added to the checkout.
        Assertions.assertEquals(newNumberOfTheProductInTheCart,numberOfTheProductInTheCartAfterAddingANew );
    }

}

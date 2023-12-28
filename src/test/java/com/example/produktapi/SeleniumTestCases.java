package com.example.produktapi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SeleniumTestCases {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new FirefoxDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }
    @Test
    void FindingMensClothing(){
 //1. Click on top menu link "Shop"
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
// 2. Click on menu link Men's Clothing
        WebElement ProductLink = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a"));
        ProductLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //3.count number items
        List<WebElement> productCategories = driver.findElements(By.className("col"));
        int numberOfProducts = productCategories.size();
        Assertions.assertEquals(4, numberOfProducts, "The number of items is not correct");
    }

  



      @Test
        void testNumberofWomensclothing(){

        //clicking on shop
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();

        //wait
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }

        //find and click on women'sclothing
        WebElement cloth= driver.findElement(By.linkText("Women's clothing"));
        cloth.click();

       //wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

       //verify number of products displayed in the page
       List<WebElement> items= driver.findElements(By.className("col"));
       Assertions.assertEquals(6,items.size());

    }

    @Test
    void testNumberofJewelery(){

        //find and click on shop
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();

        //wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //find and click on jewelery
        WebElement jewelery= driver.findElement(By.linkText("Jewelery"));
        jewelery.click();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //verify the number of products displayed in jewelery page
        List<WebElement> items= driver.findElements(By.className("col"));
        Assertions.assertEquals(4,items.size());
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

    @AfterAll
    static void teardown(){
        driver.quit();
    }


}




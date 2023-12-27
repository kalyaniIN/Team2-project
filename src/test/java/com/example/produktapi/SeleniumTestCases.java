package com.example.produktapi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @AfterAll
    static void teardown(){
        driver.quit();
    }

}

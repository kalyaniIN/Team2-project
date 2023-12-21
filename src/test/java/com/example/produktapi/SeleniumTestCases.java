package com.example.produktapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

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
}

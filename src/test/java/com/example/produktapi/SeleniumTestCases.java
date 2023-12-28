package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

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
  

}




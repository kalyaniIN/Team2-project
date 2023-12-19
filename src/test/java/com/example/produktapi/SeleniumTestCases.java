package com.example.produktapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestCases {
    private static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new FirefoxDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

    }
    @Test
    void getWebsiteUrl() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }
}

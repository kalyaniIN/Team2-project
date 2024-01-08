package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    //Kalyani
    @When("user click on All")
    public void user_click_on_All() {
        WebElement allProducts= driver.findElement(By.linkText("All"));
        allProducts.click();
    }
    //Kalyani
    @Then("verify the number of products is {int}")
    public void verify_the_number_of_total_product_is(Integer int1) {
        List<WebElement> items= driver.findElements(By.className("col"));
        Assertions.assertEquals(int1,items.size());
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

    //Finding Men's Clothing
    @When("user enters Shop")
    public void user_enters_shop() {
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    @Then("user clicks on link for Men's Clothing")
    public void user_clicks_on_link_for_men_s_clothing() {
        // 1. Click on menu link Men's Clothing
        WebElement ProductLink = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a"));
        ProductLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 2. Count number of items on Men's Clothing page
        List<WebElement> productCategories = driver.findElements(By.className("col"));
        int numberOfProducts = productCategories.size();
        Assertions.assertEquals(4, numberOfProducts, "The number of items is not correct");
    }

    @Then("product is added to cart")
    public void product_is_added_to_cart() {

        // 3. Find the Checkout button
        var GetNumberOfProductsInCart = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();

        //4. Check if cart was empty or not, if empty set value to 0.
        int NumberInCart;
        if(Objects.equals(GetNumberOfProductsInCart, "")) {
            NumberInCart = 0;
        }
        else {
            // 5. If cart is not empty then parse string value to integer.
            NumberInCart = Integer.parseInt(GetNumberOfProductsInCart);
        }
        //6. increasing the product number by 1
        int newNumberInCart = NumberInCart + 1;

        // 7. Add a Men's Clothing product to cart
        WebElement ProductAddToCart = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button"));
        ProductAddToCart.click();

        // 8. Get number of product in cart after adding a new product
        var gettingNumberOfTheProductAfterAddingANew = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();
        //9. Parsing the value from string to Int.
        int numberOfTheProductInTheCartAfterAddingANew = Integer.parseInt(gettingNumberOfTheProductAfterAddingANew);
        // 10. Verify that the product is added to the checkout.
        Assertions.assertEquals(newNumberInCart,numberOfTheProductInTheCartAfterAddingANew );
    }

    //Kalyani

    @When("the user is on shop page")
    public void goToAllProducts() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }

    //Kalyani
    @When("the user adds products to the cart and clicks checkout button")
    public void the_user_adds_products_to_the_cart_and_clicks_checkout_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the elements with the class "btn-primary" to be present
        List<WebElement> selectProducts = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("btn-primary")));
        selectProducts.get(0).click();
        selectProducts.get(7).click();
        selectProducts.get(10).click();

        // Click on the checkout button
        driver.findElement(By.className("btn")).click();
    }
    //Kalyani
    @Then("the user verifies the products in the cart")
    public void the_user_verifies_the_products_in_the_cart() {

        List<WebElement> addedProducts = driver.findElements(By.xpath("//*[@id='cartList']"));

        System.out.println("Kalyani added products" + addedProducts.size());


        for (WebElement product : addedProducts) {
            String productName = product.findElement(By.xpath(".//div/h6")).getText();
            WebElement categoryElement = product.findElement(By.xpath(".//div/small"));
            WebElement priceElement = product.findElement(By.xpath(".//span"));

            String category = categoryElement.getText();
            String price = priceElement.getText();

            // Assertions for each product
            switch (productName) {
                case "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops":
                    Assertions.assertEquals("mens clothing", category);
                    Assertions.assertEquals("$109.95", price);
                    break;
                case "Pierced Owl Rose Gold Plated Stainless Steel Double":
                    Assertions.assertEquals("jewelery", category);
                    Assertions.assertEquals("$10.99", price);
                    break;
                case "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5":
                    Assertions.assertEquals("electronics", category);
                    Assertions.assertEquals("$109", price);
                    break;
            }
        }

    }
    //Kalyani
    @Then("the user verifies the total amount in the cart")
    public void the_user_verifies_the_total_amount_in_the_cart() {
        // Use WebDriverWait to wait for the total amount element to be present
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
        WebElement totalElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cartList']/li[4]/strong")));

        // Verify total amount
        String totalAmount = totalElement.getText();
        double expectedTotal = 229.94;
        Assertions.assertEquals("$" + expectedTotal, totalAmount);
    }

    @When("user clicks on CheckOut button")
    public void user_clicks_on_check_out_button() {
        //Click on Checkout button
        driver.findElement(By.xpath("/html/body/header/div/div/div/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    @Then("The Checkout form page is visible")
    public void the_checkout_form_page_is_visible() {
        // Verify the heading of the Checkout Page
        String CheckOutPageHeading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Checkout form", CheckOutPageHeading, "The heading is not correct");
        System.out.println("Title of page is: " + CheckOutPageHeading);
    }

    @When("user clicks on Continue To Checkout Button")
    public void user_clicks_on_continue_to_checkout_button() {
        // Click on "Continue to checkout" button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ContinueToCheckoutButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/form/button"));
        js.executeScript("arguments[0].scrollIntoView();", ContinueToCheckoutButton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ContinueToCheckoutButton.click();
    }

    @Then("Error message is triggered")
    public void error_message_is_triggered() {
        //Count number of error messages
        List<WebElement> errorCategories = driver.findElements(By.className("invalid-feedback"));
        int numberOfErrorMessages = errorCategories.size();
        Assertions.assertEquals(11, numberOfErrorMessages, "The number of error message is not correct");
    }

    //Kalyani
    @When("the user is on the Shop page")
    public void the_user_is_on_the_shop_page() {
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();
    }
    //Kalyani
    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String  searchString) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys(searchString + Keys.ENTER);
        //wait

    }
    //Kalyani
    @Then("the user should see {int} search results")
    public void the_user_should_see_search_results(int expectedSearchResults) {
        int actualSearchResults = driver.findElements(By.className("col")).size();
        Assertions.assertEquals(expectedSearchResults, actualSearchResults,
                "Expected number of search results does not match the actual number");
    }

    //Kalyani
    @When("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    //Kalyani
    @Then("the homepage logo is displayed")
    public void the_homepage_logo_is_displayed() {
        boolean homePageLogo = driver.findElement(By.xpath(" /html/body/header/div/div/a")).isDisplayed();

        // Verify that the banner is displayed
        Assertions.assertTrue(homePageLogo);
    }

    //Kalyani
    @When("the user clicks on the 'Home' link in the footer")
    public void the_user_clicks_on_the_link_in_the_footer() {
        WebElement homeLink = driver.findElement(By.xpath("/html/body/div[2]/footer/ul/li[1]/a"));
        homeLink.click();
    }
    //Kalyani
    @Then("the current URL should be the Home page URL")
    public void the_current_url_should_be_the_home_page_url() {
        String currentUrl = driver.getCurrentUrl();
        String expectedHomePageUrl = "https://webshop-agil-testautomatiserare.netlify.app/";
        Assertions.assertEquals(expectedHomePageUrl, currentUrl, "Clicking on 'Home' link did not lead to the Home page");
    }

    //Kalyani
    @When("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        // Click on checkout button
        driver.findElement(By.className("btn")).click();
    }
    //Kalyani
    @When("the user clicks on the PayPal button")
    public void the_user_clicks_on_the_pay_pal_button() {
        WebElement payPalButton = driver.findElement(By.id("paypal"));
        payPalButton.click();
    }
    //Kalyani
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        WebElement redirectMessage = driver.findElement(By.id("paypalInfo"));
        Assertions.assertEquals(expectedMessage, redirectMessage.getText(),
                "Unexpected message displayed for PayPal checkout");

    }



}

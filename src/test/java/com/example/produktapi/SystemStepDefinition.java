package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SystemStepDefinition {

    static WebDriver driver;


    @Given("website is available")
    public void website_is_available() {
        driver = new FirefoxDriver();
    }

    @When("the user visits the website")
    public void the_user_visits_the_website() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "The title is not correct");
        driver.quit();
    }

    @When("user clicks on Shop")
    public void user_clicks_on_shop() {
        WebElement shop = driver.findElement(By.linkText("Shop"));
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
        WebElement jewelery = driver.findElement(By.linkText("Jewelery"));
        jewelery.click();
    }

    @Then("verify the number of product is {int}")
    public void verify_the_number_of_product_is(Integer int1) {
        List<WebElement> items = driver.findElements(By.className("col"));
        Assertions.assertEquals(int1, items.size());
    }


    @When("user click on women's clothing")
    public void user_click_on_women_s_clothing() {
        WebElement cloth = driver.findElement(By.linkText("Women's clothing"));
        cloth.click();
    }

    @When("user click on electronics")
    public void userClickOnElectronics() {
        //Go to Electronics
        driver.findElement(By.linkText("Electronics")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    @When("user select products and clicks on addToCart")
    public void user_select_products_and_clicks_on_addToCart() {
        List<WebElement> selectproduct = driver.findElements(By.className("btn-primary"));
        selectproduct.get(0).click();
        selectproduct.get(1).click();
    }

    @When("user clicks on Checkout button")
    public void user_clicks_on_checkout_button() {
        driver.findElement(By.className("btn")).click();

    }

    @Then("verify products {string} are added to cart")
    public void verify_products_are_added_to_cart(String expectedProduct) {
        List<WebElement> addedProduct = driver.findElements(By.xpath("//*[@class='col-md-5 col-lg-6 order-md-last']//*[@class='my-0 w-75']"));

        Boolean foundProduct1 = false;

        //Loop through the products in the cart and verify that the expected product is present in the cart and then set the boolean value to true
        for (WebElement i : addedProduct) {
            if (expectedProduct.equals(i.getText())) {
                foundProduct1 = true;

            }
        }

        Assertions.assertTrue(foundProduct1, "The product " + expectedProduct + "is not addded");

    }

//Suzana
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
//Suzana
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
//Suzana
    @Then("product is added to cart")
    public void product_is_added_to_cart() {

        // 3. Find the Checkout button
        var GetNumberOfProductsInCart = driver.findElement(By.xpath("//*[@id=\"buttonSize\"]")).getText();

        //4. Check if cart was empty or not, if empty set value to 0.
        int NumberInCart;
        if (Objects.equals(GetNumberOfProductsInCart, "")) {
            NumberInCart = 0;
        } else {
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
        Assertions.assertEquals(newNumberInCart, numberOfTheProductInTheCartAfterAddingANew);
    }

//Suzana
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
//Suzana
    @Then("The Checkout form page is visible")
    public void the_checkout_form_page_is_visible() {
        // Verify the heading of the Checkout Page
        String CheckOutPageHeading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Checkout form", CheckOutPageHeading, "The heading is not correct");
        System.out.println("Title of page is: " + CheckOutPageHeading);
    }
//Suzana
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
// Suzana
    @Then("Error message is triggered")
    public void error_message_is_triggered() {
        //Count number of error messages
        List<WebElement> errorCategories = driver.findElements(By.className("invalid-feedback"));
        int numberOfErrorMessages = errorCategories.size();
        Assertions.assertEquals(11, numberOfErrorMessages, "The number of error message is not correct");
    }
// Suzana.Test case button All products on start page
    @When("user clicks on All Products button")
    public void user_clicks_on_all_products_button() {
    /* 1. Click on All Products Button on the home page */
        WebElement ButtonAllProduct = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/button"));
        ButtonAllProduct.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //Suzana
    @Then("all products are displayed")
    public void all_products_are_displayed() {
        //2. Count number items
        List<WebElement> productCategories = driver.findElements(By.className("col"));
        int numberOfProducts = productCategories.size();
        Assertions.assertEquals(20, numberOfProducts, "The number of items is not correct");
    }

    // Suzana.Test case footer link Checkout on start page
    @When("user clicks on the link Checkout")
    public void user_clicks_on_the_link_checkout() {
        // 1. Click on the footer link "Checkout" on the home page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement CheckoutLink = driver.findElement(By.xpath("/html/body/div[2]/footer/ul/li[3]/a"));
        js.executeScript("arguments[0].scrollIntoView();", CheckoutLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        CheckoutLink.click();
    }
    @Then("Checkout form page is visible")
    public void Checkout_form_page_is_visible(){
        //2. The Checkout form page is displayed
        WebElement pageHeading = driver.findElement(By.tagName("h2"));
        String pageHeadingText = pageHeading.getText();
        Assertions.assertEquals("Checkout form", pageHeadingText, "The heading is not correct");
        System.out.println("The heading is: " + pageHeadingText);
    }
// Suzana. Test case Fill in all fields in Checkout form
@When("user fills in all fields")
public void user_fills_in_all_fields() {
    String search_term = "a";
    String search_term_email="a@a.com";

    driver.findElement(By.id("firstName")).sendKeys(search_term);
    driver.findElement(By.id("lastName")).sendKeys(search_term);
    driver.findElement(By.id("email")).sendKeys(search_term_email);
    driver.findElement(By.id("address")).sendKeys(search_term);
    driver.findElement(By.id("country")).sendKeys(search_term);
    driver.findElement(By.id("city")).sendKeys(search_term);
    driver.findElement(By.id("zip")).sendKeys(search_term);
    driver.findElement(By.id("cc-name")).sendKeys(search_term);
    driver.findElement(By.id("cc-number")).sendKeys(search_term);
    driver.findElement(By.id("cc-expiration")).sendKeys(search_term);
    driver.findElement(By.id("cc-cvv")).sendKeys(search_term);
}
    @Then("No error messages are triggered")
    public void no_error_messages_are_triggered() {
        Boolean errorMessages = driver.findElement(By.className("invalid-feedback")).isDisplayed();
        Assertions.assertFalse(errorMessages);
        System.out.print("No error messages are visible");
    }

}
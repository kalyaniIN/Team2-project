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

    @When("user click on All")
    public void user_click_on_All() {
        WebElement allProducts= driver.findElement(By.linkText("All"));
        allProducts.click();
    }
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

    @When("the user is on shop page")
    public void goToAllProducts() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }

    @When("the user adds the  products to the cart")
    public void the_user_adds_the_products_to_the_cart() {
        List<WebElement> selectProducts = driver.findElements(By.className("btn-primary"));
        selectProducts.get(0).click();
        selectProducts.get(7).click();
    }

    @When("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        WebElement checkoutButton = driver.findElement(By.className("btn"));
        checkoutButton.click();
    }
    @Then("the category and price of the products in the cart are verified")
    public void the_category_and_price_of_the_products_in_the_cart_are_verified() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartList")));

        verifyProductCategoryAndPrice("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "mens clothing", 109.95);
        verifyProductCategoryAndPrice("Pierced Owl Rose Gold Plated Stainless Steel Double", "jewelery", 10.99);
    }

    private void verifyProductCategoryAndPrice(String productName, String expectedCategory, double expectedPrice) {
        //Get products displayed in the cart
        List<WebElement> addedProducts = driver.findElements(By.xpath("//*[@id=\"cartList\"]/li[1]/div/h6"));

        for (WebElement product : addedProducts) {
            if (productName.equals(product.getText())) {
                // Find the category and price elements for the matched product
                WebElement categoryElement = product.findElement(By.xpath("//*[@id=\"cartList\"]/li[1]/div/small"));
                WebElement priceElement = product.findElement(By.xpath("//*[@id=\"cartList\"]/li[1]/span"));

                // Verify category
                Assertions.assertEquals(expectedCategory, categoryElement.getText(), "Incorrect category for product: " + productName);

                // Verify price
                double actualPrice = Double.parseDouble(priceElement.getText().substring(1));
                Assertions.assertEquals(expectedPrice, actualPrice, 0.01, "Incorrect price for product: " + productName);

                // Exit the loop once verification is done for the current product
                return;
            }
        }
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

    @When("the user is on the Shop page")
    public void the_user_is_on_the_shop_page() {
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();
    }
    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String  searchString) {
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys(searchString + Keys.ENTER);
    }
    @Then("the search results should contain the product {string}")
    public void the_search_results_should_contain_the_product(String expectedProduct) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));

        String actualResult = searchResult.getText();
        Assertions.assertTrue(actualResult.contains(expectedProduct), "Product not found in search results");

    }

    @When("the user is on the Home page")
    public void the_user_is_on_the_home_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }


    @Then("the homepage logo is displayed")
    public void the_homepage_logo_is_displayed() {
        boolean homePageLogo = driver.findElement(By.xpath(" /html/body/header/div/div/a")).isDisplayed();

        // Verify that the banner is displayed
        Assertions.assertTrue(homePageLogo);
    }

    @When("the user clicks on the 'Home' link in the footer")
    public void the_user_clicks_on_the_link_in_the_footer() {
        WebElement homeLink = driver.findElement(By.xpath("/html/body/div[2]/footer/ul/li[1]/a"));
        homeLink.click();
    }
    @Then("the current URL should be the Home page URL")
    public void the_current_url_should_be_the_home_page_url() {
        String currentUrl = driver.getCurrentUrl();
        String expectedHomePageUrl = "https://webshop-agil-testautomatiserare.netlify.app/";
        Assertions.assertEquals(expectedHomePageUrl, currentUrl, "Clicking on 'Home' link did not lead to the Home page");
    }


}

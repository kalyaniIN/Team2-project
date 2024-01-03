package com.example.produktapi;
import org.apache.commons.lang3.StringUtils;
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

    @Test
    void addWomenClothingToCart() {
        WebElement shop = driver.findElement(By.linkText("Shop"));
        shop.click();

        //wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //find and click on Women clothing
        WebElement cloth= driver.findElement(By.linkText("Women's clothing"));
        cloth.click();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //addtocart

       List< WebElement> selectCloth = driver.findElements(By.className("btn-primary"));
       selectCloth.get(0).click();
       selectCloth.get(1).click();

        //click on checkout button
        driver.findElement(By.className("btn")).click();

        //Get products name displayed in the cart
        List <WebElement> addedProduct = driver.findElements(By.xpath("//*[@class='col-md-5 col-lg-6 order-md-last']//*[@class='my-0 w-75']"));

        Boolean foundclothProduct1 = false;
        Boolean foundclothProduct2 = false;


        for (WebElement i : addedProduct) {
            if ("BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats".equals(i.getText()))
            {
                foundclothProduct1 = true;

            }

            if ("Lock and Love Womens Removable Hooded Faux Leather Moto Biker Jacket".equals(i.getText()))
            {
                foundclothProduct2 = true;

            }

        }

        Assertions.assertTrue(foundclothProduct1,"The product /'BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats/' is not added");
        Assertions.assertTrue(foundclothProduct2,"The Product /'Lock and Love Womens Removable Hooded Faux Leather Moto Biker Jacket/' is not added");

    }

    @Test
    void addJewelerytoCart() {
        WebElement shop = driver.findElement(By.linkText("Shop"));
        shop.click();

        //wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //find and click on jewelery
        WebElement jewelery = driver.findElement(By.linkText("Jewelery"));
        jewelery.click();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //addtocart

        List<WebElement> selectJewelery = driver.findElements(By.className("btn-primary"));
        selectJewelery.get(0).click();
        selectJewelery.get(1).click();

        //click on checkout button
        driver.findElement(By.className("btn")).click();

        //Get products name displayed in the cart
        List<WebElement> addedProduct = driver.findElements(By.xpath("//*[@class='col-md-5 col-lg-6 order-md-last']//*[@class='my-0 w-75']"));

        Boolean foundProduct1 = false;
        Boolean foundProduct2 = false;


        for (WebElement i : addedProduct) {
            if ("John Hardy Womens Legends Naga Gold & Silver Dragon Station Chain Bracelet".equals(i.getText()))
            {
               foundProduct1 = true;

            }

            if ("SolGold Petite Micropave".equals(i.getText()))
            {
                foundProduct2 = true;

            }

        }

        Assertions.assertTrue(foundProduct1,"The product /'John Hardy Womens Legends Naga Gold & Silver Dragon Station Chain Bracelet/' is not addded");
        Assertions.assertTrue(foundProduct2,"The product /'SolGold Petite Micropave /' is not added");

        }


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
    @Test
    void FindingMensClothing(){
        //1. Click on top menu link "Shop"
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // 2. Click on menu link Men's Clothing
        WebElement ProductLink = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a"));
        ProductLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //3. Count number items
        List<WebElement> productCategories = driver.findElements(By.className("col"));
        int numberOfProducts = productCategories.size();
        Assertions.assertEquals(4, numberOfProducts, "The number of items is not correct");
    }

    @Test
    void MensProductAddToCart() {
        //1. Click on top menu link "Shop"
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // 2. Click on Men's Clothing
        WebElement ProductLink = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a"));
        ProductLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 3. Getting value from Checkout button
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
    @Test
    void VerifyCheckOutButton() {
        //1. Click on Checkout button
        WebElement Checkout = driver.findElement(By.xpath("/html/body/header/div/div/div/a"));
        Checkout.click();
        // 2. Verify the heading of the Checkout Page
        String CheckOutPageHeading = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Checkout form", CheckOutPageHeading, "The heading is not correct");
        System.out.println("Title of page is: " + CheckOutPageHeading);
    }

    @Test
    void VerifyErrorMessageEmptyCheckOutForm() {
        //1. Click on Checkout button
        driver.findElement(By.xpath("/html/body/header/div/div/div/a")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // 2. Click on "Continue to checkout" button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ContinueToCheckoutButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/form/button"));
        js.executeScript("arguments[0].scrollIntoView();", ContinueToCheckoutButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ContinueToCheckoutButton.click();

        //3. Count number error messages
        List<WebElement> errorCategories = driver.findElements(By.className("invalid-feedback"));
        int numberOfErrorMessages = errorCategories.size();
        Assertions.assertEquals(11, numberOfErrorMessages, "The number of error message is not correct");

    }


        @AfterAll
        static void teardown () {
            driver.quit();
        }

    }

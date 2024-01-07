package com.example.produktapi;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class SeleniumTestCases {
    private static WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    //tests written by - Kalyani
    @Test
    void testAllProductsDisplayed() {

        //clicking on shop
        WebElement shop= driver.findElement(By.linkText("Shop"));
        shop.click();

        //wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement allLink = driver.findElement(By.linkText("All"));
        allLink.click();

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //verify number of products displayed in the page
        List<WebElement> items= driver.findElements(By.className("col"));
        Assertions.assertEquals(20,items.size());
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

    //tests written by - Kalyani
    @Test
    void testProductSearch() {

        //Go to Shop
        driver.findElement(By.linkText("Shop")).click();
        //wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Perform a case-sensitive search
        String searchString = "Women";
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys(searchString + Keys.ENTER);

       int searchResultItems = driver.findElements(By.className("col")).size();
       System.out.println(searchResultItems);

        // Assert that the actual size matches the expected size
        Assertions.assertEquals(7,searchResultItems,
                "Expected number of search results does not match the actual number");
    }

    //tests written by - Kalyani
    @Test
    void testAddProductToCartAndVerifyCart() {

        // Go to Shop
        driver.findElement(By.linkText("Shop")).click();
        // Wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Add a product to the cart
        List<WebElement> selectProducts = driver.findElements(By.className("btn-primary"));
        selectProducts.get(0).click();
        selectProducts.get(7).click();
        selectProducts.get(10).click();


        // Click on checkout button
        driver.findElement(By.className("btn")).click();
        // Print the category and price of the products in the cart
        List<WebElement> addedProducts = driver.findElements(By.xpath("//*[@id='cartList']"));
        double totalPrice = 0.0;
        for (WebElement product : addedProducts) {
            String productName = product.findElement(By.xpath(".//div/h6")).getText();
            WebElement categoryElement = product.findElement(By.xpath(".//div/small"));
            WebElement priceElement = product.findElement(By.xpath(".//span"));

            String category = categoryElement.getText();
            String price = priceElement.getText();
            System.out.println("Product: " + productName + ", Category: " + category + ", Price: " + price);

            // Assertions
            switch (productName) {
                case "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops":
                    Assertions.assertEquals("mens clothing", category);
                    Assertions.assertEquals("$109.95", price);
                    totalPrice += Double.parseDouble(price.substring(1));
                    break;
                case "Pierced Owl Rose Gold Plated Stainless Steel Double":
                    Assertions.assertEquals("jewelery", category);
                    Assertions.assertEquals("$10.99", price);
                    totalPrice += Double.parseDouble(price.substring(1));
                    break;
                case "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5":
                    Assertions.assertEquals("electronics", category);
                    Assertions.assertEquals("$109", price);
                    totalPrice += Double.parseDouble(price.substring(1));
                    break;
            }
        }
        // Verify total amount
        WebElement totalElement = driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[4]/strong"));
        String totalAmount = totalElement.getText();
        double expectedTotal = 229.94;
        Assertions.assertEquals("$" + expectedTotal, totalAmount);

    }

    //tests written by - Kalyani
    @Test
    public void testHomepageLogo() {

        boolean homePageLogo = driver.findElement(By.xpath(" /html/body/header/div/div/a")).isDisplayed();

        // Verify that the banner is displayed
        Assertions.assertTrue(homePageLogo);
    }

    //tests written by - Kalyani
    @Test
    void testFooterHomeLink() {
        WebElement homeLink = driver.findElement(By.xpath("/html/body/div[2]/footer/ul/li[1]/a"));
        homeLink.click();

        // Verify that the current URL is the Home page URL
        String currentUrl = driver.getCurrentUrl();
        String expectedHomePageUrl = "https://webshop-agil-testautomatiserare.netlify.app/";
        Assertions.assertEquals(expectedHomePageUrl, currentUrl, "Clicking on 'Home' link did not lead to the Home page");
    }

    //tests written by - Kalyani
    @Test
    void testPayPalCheckoutInfo() {
        // Click on checkout button
        driver.findElement(By.className("btn")).click();
        WebElement payPalButton = driver.findElement(By.id("paypal"));
        payPalButton.click();

        // Verify the message before redirection
        WebElement redirectMessage = driver.findElement(By.id("paypalInfo"));
        Assertions.assertEquals("You will be redirected to PayPal in the next step.", redirectMessage.getText());
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }

}

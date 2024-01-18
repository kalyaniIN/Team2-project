package com.example.produktapi;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.firefox.FirefoxOptions;


public class SeleniumTests {
    private static WebDriver driver;

    @BeforeEach
  
    public void setup() {


        var options = new FirefoxOptions();
        options.addArguments("--headless");

        driver = new FirefoxDriver(options);

        Dimension d = new Dimension(1920,3080);
        driver.manage().window().setSize(d);

        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }


    //tests written by - Kalyani
    //adding coment for github actions

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


            //Testcase written by :Uma
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

        //Testcase written by :Uma
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
        //Faisal Farman
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
        //Faisal Farman
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

        //Testcase written by :Uma
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

    //Testcase written by :Uma
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


// Suzana.
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

    //Suzana.
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
    // Suzana.
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

    //Suzana.
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
    //Faisal Farman
    @Test
    void addProductFromEachCategoryAndCheckThatItIsAddedToTheCheckOut(){
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
        newNumberOfTheProductInTheCart = newNumberOfTheProductInTheCart + 1;

        //Go to Men's clothing page
        driver.findElement(By.linkText("Men's clothing")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();
        newNumberOfTheProductInTheCart = newNumberOfTheProductInTheCart + 1;

        //Go to Women's clothing page
        driver.findElement(By.linkText("Women's clothing")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();
        newNumberOfTheProductInTheCart = newNumberOfTheProductInTheCart + 1;

        //Go to Jewelery page
        driver.findElement(By.linkText("Jewelery")).click();
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

    //Faisal Farman
    @Test
    void removeProductFromTheCart() {
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

        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Add a product to cart
        List<WebElement> productName = driver.findElements(By.xpath("//*[@class='col']//*[@class='card h-100 p-3']//*[@class='card-title fs-4']"));
        String addedProductName = productName.get(0).getText();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();

        //Go to Men's clothing page
        driver.findElement(By.linkText("Men's clothing")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();

        //Go to Women's clothing page
        driver.findElement(By.linkText("Women's clothing")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();

        //Go to Jewelery page
        driver.findElement(By.linkText("Jewelery")).click();
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Add a product to cart
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button")).click();

        //Go to checkout.
        driver.findElement(By.xpath("//*[@class='btn btn-warning']")).click();

        //Saving number of product for later assert.
        var gettingNumberOfTheProductAddedToTheCart = driver.findElement(By.xpath("//*[@id=\"cartSize\"]")).getText();
        //Parsing to Int.
        int numberOfTheProductInTheCart = Integer.parseInt(gettingNumberOfTheProductAddedToTheCart);

        //Removing product from the cart
        List<WebElement> removeButton = driver.findElements(By.xpath("//*[@id=\"cartList\"]//*[starts-with(@class,\"list-group-item d-flex\")]//*[contains(text(),\"Remove\")]"));
        removeButton.get(0).click();

        //Saving number of product after remove for later assert.
        var gettingNumberOfTheProductAfterRemove = driver.findElement(By.xpath("//*[@id=\"cartSize\"]")).getText();
        //Parsing to Int.
        int numberOfTheProductAfterRemove = Integer.parseInt(gettingNumberOfTheProductAfterRemove);
        //Verifying that the product is removed from the cart.
        //Total number of the product decrease by 1
        Assertions.assertEquals(numberOfTheProductInTheCart-1, numberOfTheProductAfterRemove);
        //Removed product is not available in Your cart
        List<WebElement> productInTheCart = driver.findElements(By.xpath("//*[@id='cartList']//*[@class='my-0 w-75']"));
        Assertions.assertNotEquals(addedProductName, productInTheCart.get(0).getText());

    }

    //Testcase written by :Uma
    @Test
    void checkShopLink_From_Footer() {
        //identify shop link from the footer
        WebElement shop = driver.findElement(By.xpath("//*[@class='nav col-md-4 justify-content-end']//*[text()='Shop']"));
        shop.click();

        //assert the title of the page
        Assertions.assertEquals("Webbutiken", driver.getTitle());

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",selectProducts.get(0));
        js.executeScript("arguments[0].click();",selectProducts.get(7));
        js.executeScript("arguments[0].click();",selectProducts.get(10));

        // Click on checkout button
        driver.findElement(By.className("btn")).click();
        // Print the category and price of the products in the cart
        List<WebElement> addedProducts = driver.findElements(By.xpath("//*[@id='cartList']"));

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
    

 // Suzana Test case "Fill in all fields in Checkout form" with no error messages visible
   @Test
   void VerifyAllFieldsFilled() {
     //1. Click on Checkout button
     driver.findElement(By.xpath("/html/body/header/div/div/div/a")).click();

     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     }
     // 2. Fill in all 11 fields with tag name input
     String search_term = "a";
     String search_term_email = "a@a.com";

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

     //3. Click on "Continue to checkout" button
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     JavascriptExecutor js = (JavascriptExecutor) driver;
     WebElement ContinueToCheckoutButton = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/form/button"));
     js.executeScript("arguments[0].scrollIntoView();", ContinueToCheckoutButton);

     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     }
     ContinueToCheckoutButton.click();

     //4. Verify that no error messages appears
     Boolean errorMessages = driver.findElement(By.className("invalid-feedback")).isDisplayed();
     Assertions.assertFalse(errorMessages);

   }

 // Suzana. Test case "Verify Button All Products" on start page
    @Test
    void VerifyButtonAllProducts() {
        // 1. Click on All Products Button on the home page
        WebElement ButtonAllProduct = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/button"));
        ButtonAllProduct.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. Count number of items
        List<WebElement> productCategories = driver.findElements(By.className("col"));
        int numberOfProducts = productCategories.size();
        Assertions.assertEquals(20, numberOfProducts, "The number of items is not correct");
    }

// Suzana
    @Test
    void VerifyFooterLinkCheckout() {

        // 1. Click on the footer link "Checkout" on the home page
        WebElement CheckoutLink = driver.findElement(By.xpath("/html/body/div[2]/footer/ul/li[3]/a"));
        CheckoutLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. The Checkout form page is displayed
        WebElement pageHeading = driver.findElement(By.tagName("h2"));
        String pageHeadingText = pageHeading.getText();
        Assertions.assertEquals("Checkout form", pageHeadingText, "The heading is not correct");
    }
        @AfterEach
        public void teardown () {
            driver.quit();
        }

    }

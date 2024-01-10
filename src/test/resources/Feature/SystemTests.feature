Feature: SystemTesting

#Testcase written by: Kalyani
  Scenario: Test title of the website
    Given website is available
    When the user visits the website
    Then the title should be "Webbutiken"


  #Testcase written by: Kalyani
  Scenario: Test the number of products displayed when clicking on All link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on All
    When wait for 1000 millisec
    Then verify the number of products is 20


   #Testcase written by:Uma
  Scenario: Test the number of products displayed when clicking on Jewelery link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on jewelery
    When wait for 1000 millisec
    Then verify the number of product is 4

   #Testcase written by:Uma
  Scenario: Test the number of products displayed when clicking on Womens clothing link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on women's clothing
    When wait for 1000 millisec
    Then verify the number of product is 6

#Testcase written by: Faisal

  Scenario: Test the number of products displayed when clicking on Electronics link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on electronics
    Then verify the number of product is 6

#Testcase written by: Suzana
  Scenario: Finding Men's Clothing
    When user enters Shop
    Then user clicks on link for Men's Clothing
#Testcase written by: Suzana
  Scenario: Adding a Mens product to Cart
    When user enters Shop
    When user clicks on link for Men's Clothing
    Then product is added to cart

  #Testcase written by: Kalyani
  Scenario: Add products to the cart and verify the cart
    Given website is available
    When the user visits the website
    When window size is maximum
    When the user is on shop page
    When wait for 1000 millisec
    When the user adds products to the cart and clicks checkout button
    Then the user verifies the products in the cart
    And the user verifies the total amount in the cart

  #Testcase written by: Suzana
  Scenario: Verify the Checkout form page
    Given website is available
    When the user visits the website
    When user clicks on CheckOut button
    Then The Checkout form page is visible

    #Testcase written by: Suzana
  Scenario: Error message triggered by empty form fields
    Given website is available
    When the user visits the website
    When window size is maximum
    When user clicks on CheckOut button
    When user clicks on Continue To Checkout Button
    Then Error message is triggered


    #Testcase written by: Kalyani
  Scenario: User searches for a product
    When the user is on the Shop page
    When the user searches for the product "Women"
    Then the user should see 7 search results

    #Testcase written by: Kalyani
  Scenario: Verify Homepage Logo
    When the user is on the Home page
    Then the homepage logo is displayed

    #Testcase written by: Kalyani
    Scenario: Verify 'Home' link in the footer
      Given website is available
      When the user visits the website
      When window size is maximum
      When the user clicks on the 'Home' link in the footer
      Then the current URL should be the Home page URL

    #Testcase written by: Kalyani
  Scenario: Verify PayPal Checkout Information
    When the user is on the checkout page
    When the user clicks on the PayPal button
    Then the user should see the message "You will be redirected to PayPal in the next step."

 #Testcase written by:Uma
 Scenario Outline: Verify jewelery is added to cart
   Given website is available
   When the user visits the website
   When user clicks on Shop
   When wait for 1000 millisec
   When user click on jewelery
   When wait for 1000 millisec
   When user select products and clicks on addToCart
   When user clicks on Checkout button
   Then verify products <PRODUCTS> are added to cart
   Examples:
     |PRODUCTS|
     |"John Hardy Womens Legends Naga Gold & Silver Dragon Station Chain Bracelet"|
     |"SolGold Petite Micropave"|

 #Testcase written by:Uma
  Scenario Outline: Verify women'sclothing is added to cart
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on women's clothing
    When wait for 1000 millisec
    When user select products and clicks on addToCart
    When user clicks on Checkout button
    Then verify products <PRODUCTS> are added to cart
Examples:
          |PRODUCTS|
          |"BIYLACLESEN Womens 3-in-1 Snowboard Jacket Winter Coats"|
          |"Lock and Love Womens Removable Hooded Faux Leather Moto Biker Jacket"|

  #Testcase written by:Uma
Scenario: Verify clicking on the shop link from footer displays products page
  Given website is available
  When the user visits the website
  When window size is maximum
  When user clicks on shop link in the footer
  Then the title should be "Webbutiken"

    #Testcase written by: Faisal
  Scenario Outline: Remove a product from the Cart
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on jewelery
    When wait for 1000 millisec
    When user select products and clicks on addToCart
    When user click on electronics
    When wait for 1000 millisec
    When user select products and clicks on addToCart
    When user clicks on link for Men's Clothing
    When wait for 1000 millisec
    When user select products and clicks on addToCart
    When user click on women's clothing
    When wait for 1000 millisec
    When user select products and clicks on addToCart
    When user clicks on Checkout button
    Then user click on remove buttton and number of product decreased
    Then Removed product <PRODUCTS> is not available in the your cart.
    Examples:
            |PRODUCTS|
            |"WD 2TB Elements Portable External Hard Drive - USB 3.0"        |

            #Testcase written by: Faisal
  Scenario: Product from different category added to the cart
      Given website is available
      When the user visits the website
      When user clicks on Shop
      When wait for 1000 millisec
      When user click on jewelery
      When wait for 1000 millisec
      When user select products and clicks on addToCart
      When user click on electronics
      When wait for 1000 millisec
      When user select products and clicks on addToCart
      When user clicks on link for Men's Clothing
      When wait for 1000 millisec
      When user select products and clicks on addToCart
      When user click on women's clothing
      When wait for 1000 millisec
      When user select products and clicks on addToCart
      Then verify the number of the product to the checkout is 8

      #Testcase written by: Suzana
  Scenario: Verify the All Products button on start page
    When the user visits the website
    When user clicks on All Products button on start page
    Then all products are displayed

#Testcase written by: Suzana
  Scenario: Verify the footer link Checkout
    Given website is available
    When the user visits the website
    When window size is maximum
    When user clicks on the footer link Checkout
    Then Checkout form page is visible

#Testcase written by: Suzana
  Scenario: Fill in all fields in Checkout form
    When the user visits the website
    When user clicks on CheckOut button
    And user fills in all fields
    When user clicks on Continue To Checkout Button
    Then No error messages are triggered
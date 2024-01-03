
Feature: SystemTesting
  Scenario: Test title of the website
    Given website is available
    When the user visits the website
    Then the title should be "Webbutiken"

  Scenario: Test the number of products displayed when clicking on Jewelery link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on jewelery
    When wait for 1000 millisec
    Then verify the number of product is 4

  Scenario: Test the number of products displayed when clicking on Womens clothing link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on women's clothing
    When wait for 1000 millisec
    Then verify the number of product is 6

  Scenario: Test the number of products displayed when clicking on Electronics link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on electronics
    Then verify the number of product is 6

  Scenario: Finding Men's Clothing
    When user enters Shop
    Then user clicks on link for Men's Clothing

  Scenario: Adding a Mens product to Cart
    When user enters Shop
    When user clicks on link for Men's Clothing
    Then product is added to cart

  Scenario: Verify the Checkout form page
    When user clicks on CheckOut button
    Then The Checkout form page is visible

  Scenario: Error message triggered by empty form fields
    When user clicks on CheckOut button
    When user clicks on Continue To Checkout Button
    Then Error message is triggered


 Scenario: Verify jewelery is added to cart
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


  Scenario: Verify the All Products button
    When user clicks on All Products button
    Then all products are displayed

  Scenario: Verify the footer link Checkout
    When user clicks on the link Checkout
    Then Checkout form page is visible

  Scenario: Fill in all fields in Checkout form
    When user clicks on CheckOut button
    And user fills in all fields
    When user clicks on Continue To Checkout Button
    Then No error messages are triggered
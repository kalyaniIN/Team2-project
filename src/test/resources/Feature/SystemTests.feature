
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

  Scenario: Error message triggered by empty form fields
    When user clicks on CheckOut button
    When user clicks on Continue To Checkout Button
    Then Error message is triggered

 


Feature: SystemTesting
  Scenario: Test title of the website
    Given website is available
    When the user visits the website
    Then the title should be "Webbutiken"

  Scenario: Test the number of products displayed when clicking on Electronics link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on electronics
    Then verify the number of product is 6

  #Scenario: Before Adding a electronics product in the cart
  #  Given User are at Shop
  #  When User clicks on Electronics
  #  Then Check products available in the cart


  Scenario: Add a electronics product to the cart
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When wait for 1000 millisec
    When user click on electronics
    When Get the number of product in the checkout
    When User click on Add to cart
    When Get the number of product in the checkout after adding a product



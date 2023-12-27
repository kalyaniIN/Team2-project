
Feature: SystemTesting
  Scenario: Test title of the website
    Given website is available
    When the user visits the website
    Then the title should be "Webbutiken"

  Scenario: Go to product category electronics.
    Given User are at Shop
    When User clicks on Electronics
    Then There will be 6 products available in the page

  #Scenario: Before Adding a electronics product in the cart
  #  Given User are at Shop
  #  When User clicks on Electronics
  #  Then Check products available in the cart


  Scenario: Adding a electronics product in the cart
    Given User are at Shop
    When User click on Add to cart
    Then Product will be added to the checkout



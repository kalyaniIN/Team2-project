
Feature: SystemTesting

Background: website is available

  Scenario: Finding Men's Clothing
    When user enters Shop
    Then user clicks on link for Men's Clothing

  Scenario: Adding Men's Clothing product to cart
    When user enters Shop
    When user clicks on link for Men's Clothing
    Then product is added to cart


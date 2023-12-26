the
Feature: SystemTesting

Background: website is available

  Scenario:
  When the user visits the website
  Then the title should be "Web shop"

  Scenario: Finding Men's Clothing
    Given the page is available
    When user enters Shop
    Then user clicks on link for Men's Clothing

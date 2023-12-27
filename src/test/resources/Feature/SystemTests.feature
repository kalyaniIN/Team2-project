
Feature: SystemTesting
  Scenario: Test title of the website
    Given website is available
    When the user visits the website
    Then the title should be "Webbutiken"


  Scenario: Test the number of products displayed when clicking on Jewelery link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When user waits for 1000 millisec
    When user click on jewelery
    When user waits for 1000 millisec
    Then verify the number of product is 4

  Scenario: Test the number of products displayed when clicking on Womens clothing link
    Given website is available
    When the user visits the website
    When user clicks on Shop
    When user waits for 1000 millisec
    When user click on women's clothing
    When user waits for 1000 millisec
    Then verify the number of product is 6
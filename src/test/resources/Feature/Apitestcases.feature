Feature: Api testing

  Scenario:TEst /my-endpoint
    When Given url
    Then Status for http request is 200

  Scenario: Retrieve all categories
    Given the application is running
    When the client requests GET /products/categories
    Then the response status should be 200
    Then the response content should contain the following categories:
      | electronics |
      | jewelery |
      | men's clothing |
      | women's clothing |



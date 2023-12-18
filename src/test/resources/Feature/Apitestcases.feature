Feature: Api testing

  Scenario:Test /my-endpoint
    When Given endpointurl
    Then Status for http request is 200

  Scenario: Verify the contentType of /endpoint
    When Given endpointurl
    Then ContentType is text

  Scenario: Verify the body of /endpoint
    When Given endpointurl
    Then  body is "Hello, world!"


  Scenario:Test /products
    When Given producturl
    Then Status for http request is 200

  Scenario: Verify the contentType of /products
    When Given producturl
    Then contentType is JSON

  Scenario: Verify the body of /products
    When Given producturl
    Then verify data in the body

  Scenario:Test /products/categories/{category}
    When Given product by category url
    Then Status for http request is 200

  Scenario: Verify the contentType of /products/categories/{category}
    When Given product by category url
    Then contentType is JSON

  Scenario: Verify the body of /products/categories/{category}
    When Given product by category url
    Then verify category in the body


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

  Scenario:Verify productID
    When Given product ID url
    Then Status for request should be 200

  Scenario: Verify the body of a product
    When Given product ID url
    Then Verify data in productID body
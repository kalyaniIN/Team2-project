Feature: Api testing

  Scenario:Test /my-endpoint
    When Given endpointurl
    Then Status for http request is 200

  Scenario: Verify the contentType of /endpoint
    When Given endpointurl
    Then ContentType is text

  Scenario:Test /products
    When Given producturl
    Then Status for http request is 200

  Scenario: Verify the contentType of /products
    When Given producturl
    Then contentType is JSON




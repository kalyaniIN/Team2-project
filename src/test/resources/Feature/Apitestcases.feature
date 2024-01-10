Feature: Api testing


# Kalyani
  Scenario: Retrieve all categories
    Given the application is running
    When the client requests GET /products/categories
    Then the response status should be 200
    Then the response content should contain the following categories:
      | electronics |
      | jewelery |
      | men's clothing |
      | women's clothing |

#Uma
  Scenario:Test /my-endpoint
    When Given endpointurl
    Then Status for http request is 200

#Uma
  Scenario: Verify the contentType of /endpoint
    When Given endpointurl
    Then ContentType is text
#Uma
  Scenario: Verify the body of /endpoint
    When Given endpointurl
    Then  body is "Hello, world!"

#Uma
  Scenario:Test /products
    When Given producturl
    Then Status for http request is 200

  #Uma
  Scenario: Verify the contentType of /products
    When Given producturl
    Then contentType is JSON

#Uma
  Scenario: Verify the body of /products
    When Given producturl
    Then verify data in the body

  #Suzana
  Scenario:Verify productID
    When Given product ID url
    Then Status for request should be 200

    #Faisal
  Scenario:Test /products/categories/{category}
    When Given product by category url
    Then Status for http request is 200

#Faisal
  Scenario: Verify the contentType of /products/categories/{category}
    When Given product by category url
    Then contentType is JSON

#Faisal
  Scenario: Verify the body of /products/categories/{category}
    When Given product by category url
    Then verify category in the body

#Suzana
  Scenario: Verify the body of a product
    When Given product ID url
    Then Verify data in productID body
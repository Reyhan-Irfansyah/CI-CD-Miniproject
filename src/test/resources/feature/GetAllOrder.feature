Feature: Testing RESTful API Get all orders (ALTA SHOP)

# Get all orders
  @TC26
  Scenario: Verify Successfully Get all orders
    Given I set endpoints for Successfully Get all orders
    When a valid Bearer Token is provided
    And I request all orders with valid credentials
    And the response code should be 200 for Successfully Get all orders
    Then I received the correct all orders

  @TC27
  Scenario: Verify Get all orders with Invalid Token
    Given I set endpoints for Get all orders with Invalid Token
    When an invalid Bearer Token is provided
    And I request all orders with an invalid token
    And the response code should be 401 for Get all orders with Invalid Token
    Then I received a error message for invalid Token

  @TC28
  Scenario: Verify Get all orders without Token
    Given I set endpoints for Get all orders without Token
    When no Bearer Token is provided
    And I request all orders without a token
    And the response status code should be 401 for Get all orders without Token
    Then I received a error message for invalid token a error message for missing Token
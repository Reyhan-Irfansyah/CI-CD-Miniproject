Feature: Testing RESTful API Create a new order (ALTA SHOP)

# Create a new order
  @TC23
  Scenario: Verify Successfully Create a new order
    Given I set endpoints for Successfully Create a new order
    When a valid bearer token is Provided
    And I Send HTTP Request for Create a new order
    And the response code should be 200 for Successfully Create a new order
    Then I received the correct user data

  @TC24
  Scenario: Verify Create a new order with Invalid Token
    Given I set endpoints for Create a new order with Invalid Token
    When an invalid bearer Token is provided
    And I Send HTTP Request for Create a new order with Invalid Token
    And the response code should be 401 for Create a new order with Invalid Token
    Then I received a error message for Invalid token

  @TC25
  Scenario: Verify Create a new order without Token
    Given I set endpoints for Create a new order without Token
    When no bearer Token is provided
    And I Send HTTP Request for Create a new order without Token
    And the response status code should be 401 for Create a new order without Token
    Then I received a error message for invalid Token a error message for missing token
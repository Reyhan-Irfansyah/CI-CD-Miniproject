Feature: Testing RESTful API Get order by ID (ALTA SHOP)

#  Get order by ID
  @TC29
  Scenario: Verify Successfully Get orders by ID
    Given I set endpoints for Successfully Get orders by ID
    When a Valid Bearer Token is provided
    And I request orders By ID with valid credentials
    And the response code should be 200 for Successfully Get orders By ID
    Then I received the correct orders By ID

  @TC30
  Scenario: Verify Get orders by ID with Invalid Token
    Given I set endpoints for Get orders by ID with Invalid Token
    When an Invalid Bearer Token is provided
    And I request orders by ID with an invalid token
    And the response code should be 401 for Get orders by ID with Invalid Token
    Then I Received a error message for invalid Token

  @TC31
  Scenario: Verify Get orders by ID without Token
    Given I set endpoints for Get orders by ID without Token
    When No Bearer Token is provided
    And I request orders by ID without a token
    And the response status code should be 401 for Get orders by ID without Token
    Then I Received a error message for invalid token a error message for missing Token


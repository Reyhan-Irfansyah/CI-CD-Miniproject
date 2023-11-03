Feature: Testing RESTful API Get User Information (ALTA SHOP)

# Get User Information
  @TC20
  Scenario: Verify Successfully Get User Information
    Given I set endpoints for Successfully Get User Information
    When a valid bearer token is provided
    And I request user information with valid credentials
    And the response code should be 200 for Successfully Get User Information
    Then I received the correct user details

  @TC21
  Scenario: Verify Get User Information with Invalid Token
    Given I set endpoints for Get User Information with Invalid Token
    When an invalid bearer token is provided
    And I request user information with an invalid token
    And the response code should be 401 for Get User Information with Invalid Token
    Then I received a error message for invalid token

  @TC22
  Scenario: Verify Get User Information without Token
    Given I set endpoints for Get User Information without Token
    When no bearer token is provided
    And I request user information without a token
    And the response status code should be 401 for Get User Information without Token
    Then I received a error message for invalid token a error message for missing token


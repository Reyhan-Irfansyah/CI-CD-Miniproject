Feature: Testing RESTful API Login (ALTA SHOP)

#Login
  @TC10
  Scenario: Verify Successful User Login
    Given I set endpoints for Successful User Login
    When I login with valid credentials
    And the response status code should be 200 for Successful User Login
    Then I received a data

  @TC11
  Scenario: Verify User Login with Unregistered Email
    Given I set endpoints for Login with Unregistered Email
    When I login with an unregistered email
    And the response status code should be 400 for Login with Unregistered Email
    Then I received a error message for unregistered email

  @TC12
  Scenario: Verify User Login with Incorrect Password
    Given I set endpoints for Login with Incorrect Password
    When I login with an incorrect password
    And the response status code should be 400 for Login with Incorrect Password
    Then I received a error message for incorrect password

  @TC13
  Scenario: Verify User Login with Empty Email
    Given I set endpoints for Login with Empty Email
    When I login with an empty email
    And the response status code should be 400 for Login with Empty Email
    Then I received a error message for empty email

  @TC14
  Scenario: Verify User Login with Empty Password
    Given I set endpoints for Login with Empty Password
    When I login with an empty password
    And the response status code should be 400 for Login with Empty Password
    Then I received a error message for empty password

#  @TC15
#  Scenario: Verify User Login with only Spaces in email
#    Given I set endpoints for Login with Spaces in email
#    When I fill in the email with spaces
#    And the response status code should be 400 for Login with Spaces in email
#    Then I received a error message for Login with Spaces in email
#
#  @TC16
#  Scenario: Verify User Login with Only Spaces in password
#    Given I set endpoints for Login with Spaces in password
#    When I fill in the password with spaces
#    And the response status code should be 400 for Login with Spaces in password
#    Then I received a error message for Login with Spaces in password
#
#  @TC17
#  Scenario: Verify User Login with Only Special Characters in Email
#    Given I set endpoints for Login with Special Characters in Email
#    When I login with a Email with Special Characters
#    And the response status code should be 400 for Login with Special Characters in Email
#    Then I received a error message for Login with Special Characters in Email

  @TC18
  Scenario: Verify User Login with Special Characters in Password
    Given I set endpoints for Login with Special Characters in Password
    When I login with Special Characters in a password
    And the response status code should be 200 for Login with Special Characters in Password
    Then I received a error message for Login with Special Characters in Password

  @TC19
  Scenario:  Verify User Login with Fill in email with valid password, and Fill in password with valid email
    Given I set endpoints for Login with Fill in email with valid password, and Fill in password with valid email
    When I login with Fill in email with valid password, and Fill in password with valid email
    And the response status code should be 400 for Login with Fill in email with valid password, and Fill in password with valid email
    Then I received a error message for for Login with Fill in email with valid password, and Fill in password with valid email

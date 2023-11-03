Feature: Testing RESTful API Registration (ALTA SHOP)

#Registration
  @TC01
  Scenario: Verify Successful User Registration
    Given I set endpoints for Successful User Registration
    When I register with valid details
    And the response status code should be 200 for Successful User Registration
    Then I received a user id

  @TC02
  Scenario: Verify User Registration with Existing Email
    Given I set endpoints for User Registration with Existing Email
    When I register with an already registered email
    And the response status code should be 400 for User Registration with Existing Email
    Then I received a error message for existing email

  @TC03
  Scenario: Verify User Registration with Empty Email
    Given I set endpoints for User Registration with Empty Email
    When I register with an empty email
    And the response status code should be 400 for User Registration with Empty Email
    Then I received a error message for Registration with Empty Email

  @TC04
  Scenario: Verify User Registration with Empty Password
    Given I set endpoints for User Registration with Empty Password
    When I register with an empty password
    And the response status code should be 400 for Registration with Empty Password
    Then I received a error message for Registration with Empty Password

  @TC05
  Scenario: Verify User Registration with Empty Full Name
    Given I set endpoints for User Registration with Empty Full Name
    When I register with an empty full name
    And the response status code should be 400 for User Registration with Empty Full Name
    Then I received a error message for Registration with Empty Full Name

#  @TC06
#  Scenario: Verify User Registration with Special Characters in Full Name
#    Given I set endpoints for User Registration with Special Characters in Full Name
#    When I register with a full name that contains special characters
#    And the response status code should be 400 For Registration with Special Characters in Full Name
#    Then I received a error message for Registration with Special Characters in Full Name
#
#  @TC07
#  Scenario: Verify User Registration with Spaces in password
#    Given I set endpoints for User Registration with Spaces in password
#    When I registered a password with spaces
#    And the response status code should be 400 for Registration with Spaces in password
#    Then I received a error message for Registration with Spaces in password
#
#  @TC08
#  Scenario: Verify User Registration with Special Characters in Email
#    Given I set endpoints for User Registration with Special Characters in Email
#    When I register with Special Characters in Email
#    And the response status code should be 400 for Registration with Special Characters in Email
#    Then I received a error message for Registration with Special Characters in Email

  @TC09
  Scenario: Verify User Registration with Special Characters in password
    Given I set endpoints for Registration with Special Characters in password
    When I Registration with Special Characters in a password
    Then the response status code should be 200 for User Registration with Special Characters in password
    And I received a user Id
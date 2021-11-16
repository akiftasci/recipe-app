Feature: Authentication

#TODO:Fill step definitions
  Scenario: Login with credentials
    Given The user is on the authentication page
    When  the user puts username
    And   the user puts in the password
    Then  the user should be able to generate token with credentials

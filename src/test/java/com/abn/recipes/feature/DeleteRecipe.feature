Feature: Authentication

  Scenario: Remove recipe with id
    Given The user is logged in
    When  the user deletes a recipe with id
    Then  the related recipe should be removed from the list





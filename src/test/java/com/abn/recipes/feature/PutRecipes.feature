Feature: Authentication

  Scenario: Update recipe with new name
    Given The user is logged in and has token
    When  the user changes the name of a recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new name

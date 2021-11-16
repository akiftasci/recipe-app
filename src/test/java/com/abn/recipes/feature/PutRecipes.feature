Feature: Authentication

  Scenario: Update recipe with new name
    Given The user is logged in and has token
    When  the user changes the name of a recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new name

  Scenario: Update recipe with new name
    Given The user is logged in
    When  the user changes the name of a recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new name

  Scenario: Update recipe with new portion value
    Given The user is logged in
    When  the user changes the portion of a recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new portion value

  Scenario: Update recipe with new vegetarian value
    Given The user is logged in
    When  the user changes the vegetarian of recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new vegetarian value

  Scenario: Update recipe with new instructions
    Given The user is logged in
    When  the user changes the instructions of a recipe from the list of recipes
    And   user updates the recipe
    Then  the recipe should be updated with the new instructions

  Scenario: Update recipe with new ingredient name
    Given The user is logged in
    When  the user changes the ingredient of recipe from the list of recipes
    And   user changes ingredients name
    And   user updates the recipe
    Then  the recipe should be updated with the new ingredient name

  Scenario: Update recipe with new ingredient amount
    Given The user is logged in
    When  the user changes the ingredient of recipe from the list of recipes
    And   user changes ingredients amount
    And   user updates the recipe
    Then  the recipe should be updated with the new ingredient amount
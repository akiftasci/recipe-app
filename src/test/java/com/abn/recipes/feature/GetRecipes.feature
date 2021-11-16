Feature: Authentication


Scenario: Get all recipes as a list
  Given The user is logged in and has token
  When  the user makes get request with token
  Then  the user should see the all available recipes as a list

  Scenario: Get recipe from id
    Given The user is logged in and has token
    When  the user makes a get request with token and id of recipe
    Then  the user should see the recipe with id requested
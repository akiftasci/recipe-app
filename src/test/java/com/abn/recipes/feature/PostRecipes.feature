Feature: Authentication

  Scenario: Login with credentials
    Given The user is on the authentication page
    When  the user puts username
    And   the user puts in the password
    Then  the user should be able to generate token with credentials

#  Scenario: Create new recipe
#    Given The user is logged in
#    When  the user creates a new recipe
#    Then  the recipe should be in the recipe list

#  Scenario: Unauthorized user action
#    Given The user is not logged in and does not have token
#    When  the user tries to get the list of recipes
#    Then  the response should be '403' unauthorized

#  Scenario: Update recipe with new name
#    Given The user is logged in
#    When  the user changes the name of a recipe from the list of recipes
#    And   user updates the recipe
#    Then  the recipe should be updated with the new name

#  Scenario: Update recipe with new portion value
#    Given The user is logged in
#    When  the user changes the portion of a recipe from the list of recipes
#    And   user updates the recipe
#    Then  the recipe should be updated with the new portion value

#  Scenario: Update recipe with new vegetarian value
#    Given The user is logged in
#    When  the user changes the vegetarian of recipe from the list of recipes
#    And   user updates the recipe
#    Then  the recipe should be updated with the new vegetarian value

#  Scenario: Update recipe with new instructions
#    Given The user is logged in
#    When  the user changes the instructions of a recipe from the list of recipes
#    And   user updates the recipe
#    Then  the recipe should be updated with the new instructions

#  Scenario: Update recipe with new ingredient name
#    Given The user is logged in
#    When  the user changes the ingredient of recipe from the list of recipes
#    And   user changes ingredients name
#    And   user updates the recipe
#    Then  the recipe should be updated with the new ingredient name

#  Scenario: Update recipe with new ingredient amount
#    Given The user is logged in
#    When  the user changes the ingredient of recipe from the list of recipes
#    And   user changes ingredients amount
#    And   user updates the recipe
#    Then  the recipe should be updated with the new ingredient amount

#  Scenario: Remove recipe from the list
#    Given The user is logged in
#    When  the user deletes a recipe from the list of recipes
#    Then  the recipe should be removed from the list

#  Scenario: Remove recipe with id
#    Given The user is logged in
#    When  the user deletes a recipe with id
#    Then  the related recipe should be removed from the list
#
#
#
#

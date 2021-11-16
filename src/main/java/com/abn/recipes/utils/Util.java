package com.abn.recipes.utils;

import com.abn.recipes.dto.IngredientDto;
import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Ingredient;
import com.abn.recipes.model.Recipe;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    /**
     * Converts LocalDateTime object to String.
     * @param created the date object that wants to be converted.
     * @return LocalDateTime object converted to String.
     **/
    public static String convertLocalDateTimeToString(final LocalDateTime created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MM - yyyy HH:mm");

        return formatter.format(created);
    }

    /**
     * Converts String to LocalDateTime object.
     * @param created the String that wants to be converted.
     * @return String converted to LocalDateTime object.
     **/
    public static LocalDateTime convertStringToLocalDateTime(final String created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MM - yyyy HH:mm");

        return LocalDateTime.parse(created, formatter);
    }

    /**
     * Converts data transfer object to entity.
     * @param recipeDto DTO object that wants to be converted to entity.
     * @return Recipe that has been converted from DTO.
     **/
    public static Recipe convertToEntity(final RecipeDto recipeDto) {
        Recipe recipe = new Recipe();

        recipe.setName(recipeDto.getName());
        recipe.setPortion(recipeDto.getPortion());
        recipe.setVegetarian(recipeDto.isVegetarian());
        recipe.setInstructions(recipeDto.getInstructions());

        recipe.setIngredients(recipeDto.getIngredients().stream().map(n -> {
            final Ingredient ingredient = new Ingredient();

            ingredient.setName(n.getName());
            ingredient.setAmount(n.getAmount());
            ingredient.setRecipe(recipe);

            return ingredient;
        }).collect(Collectors.toList()));

        return recipe;
    }

    /**
     * Converts entity to data transfer object.
     * @param  recipe object that wants to be converted to dto.
     * @return Entity that has been converted to DTO.
     **/
    public static RecipeDto convertToRecipeDto(final Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setId(recipe.getId());
        recipeDto.setDate(Util.convertLocalDateTimeToString(recipe.getCreated()));

        return recipeDto;
    }

    /**
     * Converts list of entity to data transfer object list.
     * @param  recipeList list of objects that wants to be converted to list of dtos.
     * @return Entities that has been converted to DTO's as a list.
     **/
    public static List<RecipeDto> entityToDto(final List<Recipe> recipeList) {
        return recipeList.stream().map(recipe -> {

            final RecipeDto recipeDto = new RecipeDto();

            recipeDto.setId(recipe.getId());
            recipeDto.setDate(Util.convertLocalDateTimeToString(recipe.getCreated()));
            recipeDto.setName(recipe.getName());
            recipeDto.setVegetarian(recipe.isVegetarian());
            recipeDto.setPortion(recipe.getPortion());
            recipeDto.setInstructions(recipe.getInstructions());

            recipeDto.setIngredients(recipe.getIngredients().stream().map(ingredient -> {
                IngredientDto ingredientDto = new IngredientDto();

                ingredientDto.setName(ingredient.getName());
                ingredientDto.setAmount(ingredient.getAmount());

                return ingredientDto;
            }).collect(Collectors.toList()));

            return recipeDto;
        }).collect(Collectors.toList());

    }

    /**
     * Converts list of entity to data transfer object list.
     * @param  recipeDto list of objects that wants to be converted to list of dtos.
     * @return Entities that has been converted to DTO's as a list.
     **/
    public static Recipe convertRecipeDtoToEntityToUpdate(final RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setCreated(convertStringToLocalDateTime(recipeDto.getDate()));
        recipe.setPortion(recipeDto.getPortion());
        recipe.setVegetarian(recipeDto.isVegetarian());
        recipe.setInstructions(recipeDto.getInstructions());

        recipe.setIngredients(recipeDto.getIngredients().stream().map(ingredientDto -> {
            final Ingredient ingredient = new Ingredient();

            ingredient.setName(ingredientDto.getName());
            ingredient.setAmount(ingredientDto.getAmount());
            ingredient.setRecipe(recipe);

            return ingredient;
        }).collect(Collectors.toList()));

        return recipe;
    }
}

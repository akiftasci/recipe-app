package com.abn.recipes.util;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Ingredient;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.service.RecipeService;
import com.abn.recipes.utils.Util;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

//todo:converter util class
public class UtilTest {
    private RecipeService recipeService;
    private final String desiredFormat = "12-11-2021 19:02";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFormatDate() {
        final String formattedDate = Util.convertLocalDateTimeToString(LocalDateTime.of(2021, 11, 12, 19, 2));
        Assertions.assertThat(formattedDate).isEqualTo(desiredFormat);
    }

    @Test
    public void testFormatDateConversionFromStringToLocalDateTime() {
        String date = "10 - 02 - 1996 08:30";

        final LocalDateTime converted = Util.convertStringToLocalDateTime(date);
        Assertions.assertThat(converted.getHour()).isEqualTo(8);
        Assertions.assertThat(converted.getMinute()).isEqualTo(30);
        Assertions.assertThat(converted.getYear()).isEqualTo(1996);
        Assertions.assertThat(converted.getMonthValue()).isEqualTo(2);
        Assertions.assertThat(converted.getDayOfMonth()).isEqualTo(10);

    }

    @Test
    public void testConvertRecipeDto() {
        Recipe recipe = createTestRecipeFajita();

        final RecipeDto recipeDto = Util.convertRecipeDto(recipe);

        Assertions.assertThat(recipeDto.getId()).isEqualTo(1);
        Assertions.assertThat(recipeDto.getDate()).isEqualTo(desiredFormat);
    }

    @Test
    public void testEntityToDto() {
        final Recipe recipeFajita = createTestRecipeFajita();
        final Recipe recipeShrimp = createTestRecipeShrimp();

        List<Recipe> recipeList = new ArrayList<>();

        recipeList.add(recipeFajita);
        recipeList.add(recipeShrimp);

        final List<RecipeDto> dtos = Util.entityToDto(recipeList);
        Assertions.assertThat(dtos.size()).isEqualTo(2);

    }

    public static Recipe createTestRecipeFajita() {
        final Recipe recipe = new Recipe();
        String instructions = "Heat 1 tablespoon of the oil in large skillet on medium-high heat. Add chicken; cook " +
            "and stir 3 minutes or until lightly browned. Remove from skillet.Heat remaining 1 tablespoon oil in same" +
            " skillet. Add onion and bell pepper; cook and stir 3 to 5 minutes. Return chicken to skillet. Add water" +
            " and Seasoning Mix; cook and stir 3 minutes or until heated through. Spoon into warm tortillas. Serve " +
            "with assorted toppings, if desired.";
        List<Ingredient> ingredientList = createTestIngredientsFajita();

        recipe.setId(1L);
        recipe.setName("Chicken Fajitas");
        recipe.setCreated(LocalDateTime.of(2021, 11, 12, 19, 2));
        recipe.setPortion(4);
        recipe.setVegetarian(true);
        recipe.setIngredients(ingredientList);
        recipe.setInstructions(instructions);

        return recipe;
    }

    public static List<Ingredient> createTestIngredientsFajita() {
        final List<Ingredient> ingredientList = new ArrayList<>();
        final Ingredient ingredient = new Ingredient();

        ingredient.setName("Vegetable oil");
        ingredient.setAmount("2 tablespoon");
        ingredientList.add(ingredient);

        ingredient.setName("Chicken Breast");
        ingredient.setAmount("1 pound");
        ingredientList.add(ingredient);

        ingredient.setName("Onion");
        ingredient.setAmount("1 medium");
        ingredientList.add(ingredient);

        return ingredientList;
    }

    public static Recipe createTestRecipeShrimp() {
        final Recipe recipe = new Recipe();
        String instructions = "Mix oil, spices and sugar in large bowl until well blended. Add shrimp; toss to coat " +
            "well. Thread shrimp onto skewers. Grill over medium heat 2 to 3 minutes per side or just until shrimp " +
            "turn pink.";
        List<Ingredient> ingredientList = createTestIngredientsShrimp();

        recipe.setId(12L);
        recipe.setName("Chicken Fajitas");
        recipe.setCreated(LocalDateTime.of(2021, 11, 12, 20, 34));
        recipe.setPortion(4);
        recipe.setVegetarian(true);
        recipe.setIngredients(ingredientList);
        recipe.setInstructions(instructions);

        return recipe;
    }

    public static List<Ingredient> createTestIngredientsShrimp() {
        final List<Ingredient> ingredientList = new ArrayList<>();
        final Ingredient ingredient = new Ingredient();

        ingredient.setName("Vegetable oil");
        ingredient.setAmount("1 tablespoon");
        ingredientList.add(ingredient);

        ingredient.setName("Shrimp");
        ingredient.setAmount("10 jumbo");
        ingredientList.add(ingredient);

        ingredient.setName("Onion");
        ingredient.setAmount("1 medium");
        ingredientList.add(ingredient);

        return ingredientList;
    }

    public static ArrayList<Recipe> getListOfRecipes() {
        final Recipe shrimp = createTestRecipeShrimp();
        final Recipe recipeFajita = createTestRecipeFajita();
        ArrayList<Recipe> recipeArrayList = new ArrayList<>();
        recipeArrayList.add(shrimp);
        recipeArrayList.add(recipeFajita);
        return recipeArrayList;
    }
}

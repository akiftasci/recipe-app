package com.abn.recipes.service;

import com.abn.recipes.dto.IngredientDto;
import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import com.abn.recipes.util.UtilTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {
        private RecipesRepository recipesRepositoryMock;
        private RecipeService recipeService;

    @Before
    public void setUp() throws Exception{
        recipesRepositoryMock = mock(RecipesRepository.class);
        recipeService = new RecipeService(recipesRepositoryMock);
    }

    @Test
    public void testGetRecipes(){

        //Given
        final ArrayList<Recipe> recipesExpected = UtilTest.getListOfRecipes();
        when(recipesRepositoryMock.findAll()).thenReturn(recipesExpected);
        //When
        final List<Recipe> receiptsActual = recipeService.getRecipes();
        //Then
        Assertions.assertThat(recipesExpected.size() ).isEqualTo(receiptsActual.size());

    }
    @Test
    public void testGetRecipesException(){

        //Given
        final ArrayList<Recipe> recipesExpected = UtilTest.getListOfRecipes();
        when(recipesRepositoryMock.findAll()).thenReturn(recipesExpected);
        //When
        final List<Recipe> receiptsActual = recipeService.getRecipes();
        //Then
        Assertions.assertThat(recipesExpected.size() ).isEqualTo(receiptsActual.size());

    }
    @Test
    public void testPersistData(){

        //Given
        final Recipe recipeExpected = UtilTest.createTestRecipeFajita();
        when(recipesRepositoryMock.save(recipeExpected)).thenReturn(recipeExpected);
        //When
        final Recipe receiptsActual = recipeService.persistData(recipeExpected);
        //Then
        Assertions.assertThat(recipeExpected.getId()).isEqualTo(receiptsActual.getId());

    }

    public static RecipeDto createRecipeDto(){
        final RecipeDto recipeDto = new RecipeDto();
        String instructions = "Mix oil, spices and sugar in large bowl until well blended. Add shrimp; toss to coat " +
            "well. Thread shrimp onto skewers. Grill over medium heat 2 to 3 minutes per side or just until shrimp " +
            "turn pink.";
        final List<IngredientDto> dto = createTestIngredientsShrimpDto();
        recipeDto.setName("Chicken Fajitas");
        recipeDto.setPortion(4);
        recipeDto.setVegetarian(true);
        recipeDto.setIngredients(dto);
        recipeDto.setInstructions(instructions);

        return recipeDto;
    }
    public static List<IngredientDto> createTestIngredientsShrimpDto() {
        final List<IngredientDto> ingredientList = new ArrayList<>();
        final IngredientDto ingredient = new IngredientDto();

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
}

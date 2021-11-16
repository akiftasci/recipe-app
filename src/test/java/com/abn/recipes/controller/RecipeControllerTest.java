package com.abn.recipes.controller;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import com.abn.recipes.service.MyUserDetailsService;
import com.abn.recipes.service.RecipeService;
import com.abn.recipes.util.UtilTest;
import com.abn.recipes.utils.JwtUtil;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecipeControllerTest {
    private RecipesRepository recipesRepositoryMock;
    private RecipeService recipeServiceMock;
    private RecipeController recipeController;
    private AuthenticationManager authenticationManager;
    private MyUserDetailsService userDetailsService;
    private JwtUtil jwtTokenUtil;

    @Before
    public void setUp() throws Exception {
        recipesRepositoryMock = mock(RecipesRepository.class);
        recipeServiceMock = mock(RecipeService.class);
        recipeController = new RecipeController(recipeServiceMock,
            authenticationManager, userDetailsService, jwtTokenUtil);
    }

    @Test
    public void testGetRecipes() {

        //Given
        final ArrayList<Recipe> recipesExpected = UtilTest.getListOfRecipes();
        when(recipeServiceMock.getRecipes()).thenReturn(recipesExpected);
        //When
        final List<RecipeDto> receiptsActual = recipeController.getRecipes();
        //Then
        Assertions.assertThat(recipesExpected.size()).isEqualTo(receiptsActual.size());

        Assertions.assertThat(recipesExpected.get(0).getName())
            .isEqualTo(receiptsActual.get(0).getName());

        Assertions.assertThat(recipesExpected.get(0).getInstructions())
            .isEqualTo(receiptsActual.get(0).getInstructions());

        Assertions.assertThat(recipesExpected.get(0).getPortion())
            .isEqualTo(receiptsActual.get(0).getPortion());

        Assertions.assertThat(recipesExpected.get(0).getIngredients().get(0).getName())
            .isEqualTo(receiptsActual.get(0).getIngredients().get(0).getName());

        Assertions.assertThat(recipesExpected.get(0).getIngredients().get(0).getAmount())
            .isEqualTo(receiptsActual.get(0).getIngredients().get(0).getAmount());
    }
    @Test
    public void testGetRecipesById() {

        //Given
        final ArrayList<Recipe> recipesExpected = UtilTest.getListOfRecipes();
        when(recipeServiceMock.getRecipes()).thenReturn(recipesExpected);
        //When
        final List<RecipeDto> receiptsActual = recipeController.getRecipes();
        //Then
        Assertions.assertThat(recipesExpected.size()).isEqualTo(receiptsActual.size());

        Assertions.assertThat(recipesExpected.get(0).getName())
            .isEqualTo(receiptsActual.get(0).getName());

        Assertions.assertThat(recipesExpected.get(0).getInstructions())
            .isEqualTo(receiptsActual.get(0).getInstructions());

        Assertions.assertThat(recipesExpected.get(0).getPortion())
            .isEqualTo(receiptsActual.get(0).getPortion());

        Assertions.assertThat(recipesExpected.get(0).getIngredients().get(0).getName())
            .isEqualTo(receiptsActual.get(0).getIngredients().get(0).getName());

        Assertions.assertThat(recipesExpected.get(0).getIngredients().get(0).getAmount())
            .isEqualTo(receiptsActual.get(0).getIngredients().get(0).getAmount());

    }
    @Test
    public void testDeleteRecipeById() {

        //Given
        final ArrayList<Recipe> recipesExpected = UtilTest.getListOfRecipes();
        when(recipeServiceMock.getRecipes()).thenReturn(recipesExpected);
        //When
        final List<RecipeDto> receiptsActual = recipeController.getRecipes();
        //Then
        Assertions.assertThat(recipesExpected.size()).isEqualTo(receiptsActual.size());

    }
}

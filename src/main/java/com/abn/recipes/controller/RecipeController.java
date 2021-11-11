package com.abn.recipes.controller;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Ingredient;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import com.abn.recipes.service.RecipeService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recepies/")
public class RecipeController {

    @Autowired
    RecipesRepository recipesRepository;

    @GetMapping(value = "/")
    public List<Recipe> getRecipes (){

        return recipesRepository.findAll();
    }

    @PostMapping(value = "/")
    public RecipeDto persist(@RequestBody final RecipeDto recipeDto){

        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setPortion(recipeDto.getPortion());
        recipe.setVegetarian(recipeDto.isVegetarian());

        recipe.setIngredients(recipeDto.getIngredients().stream().map(n -> {
            final Ingredient ingredient = new Ingredient();
            ingredient.setName(n.getName());
            ingredient.setAmount(n.getAmount());
            ingredient.setRecipe(recipe);
            return ingredient;
        }).collect(Collectors.toList()));

        final Recipe save = recipesRepository.save(recipe);
        //model mapperlara bak
         recipeDto.setId(save.getId());
         recipeDto.setDate(RecipeService.convertDateFormat(save.getCreated()));
         return recipeDto;
    }

}

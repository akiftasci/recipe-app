package com.abn.recipes.controller;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import com.abn.recipes.service.RecipeService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    RecipesRepository recipesRepository;

    public RecipeController(final RecipeService recipeService, RecipesRepository recipesRepository) {
        this.recipeService = recipeService;
        this.recipesRepository = recipesRepository;
    }

    @GetMapping(value = "/")
    public List<RecipeDto> getRecipes() {
        return recipeService.getReceipts();
    }

    @PostMapping(value = "/")
    public RecipeDto persistRecipe(@RequestBody final RecipeDto recipeDto) {
        return recipeService.persistData(recipeDto);
    }

    @PutMapping(value = "/update")
    public Recipe updateRecipe(@RequestBody Recipe recipeDto){
    return recipeService.update(recipeDto);
    }

}

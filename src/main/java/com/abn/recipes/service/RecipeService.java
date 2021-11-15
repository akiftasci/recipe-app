package com.abn.recipes.service;

import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipesRepository recipesRepository;

    public RecipeService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;

    }

    public List<Recipe> getRecipes() {
        return recipesRepository.findAll();
    }

    public Recipe persistData(final Recipe recipe) {
        return recipesRepository.save(recipe);
    }

    public Recipe getRecipe(Long id) {
        final Optional<Recipe> recipe = recipesRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe.get();
        }
        throw new RuntimeException();
    }

    public Recipe update(final Recipe recipe) {
        return recipesRepository.save(recipe);
    }

    public Recipe delete(final Long id) {
        final Optional<Recipe> recipe = recipesRepository.findById(id);
        if (recipe.isPresent()) {
            recipesRepository.deleteById(id);
            return recipe.get();
        }
        throw new RuntimeException();
    }
}

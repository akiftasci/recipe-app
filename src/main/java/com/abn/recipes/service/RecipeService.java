package com.abn.recipes.service;

import com.abn.recipes.dto.RecipeDto;
import com.abn.recipes.exception.RecipeNotFoundException;
import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import com.abn.recipes.utils.Util;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final RecipesRepository recipesRepository;

    public RecipeService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;

    }

    public List<RecipeDto> getReceipts() {
        final List<Recipe> all = recipesRepository.findAll();

        return Util.entityToDto(all);

    }

    public RecipeDto persistData(final RecipeDto recipeDto1) {
        Recipe recipe = Util.modelMapper(recipeDto1);

        final Recipe save = recipesRepository.save(recipe);

        return Util.convertRecipeDto(save);
    }

    public RecipeDto getRecipe(Integer id)  {
        final Optional<Recipe> recipe = recipesRepository.findById(id);
            return Util.convertRecipeDto(recipe.get());

    }
    public Recipe update(final Recipe recipe){
        Recipe save = recipesRepository.save(recipe);
        return save;
    }
}

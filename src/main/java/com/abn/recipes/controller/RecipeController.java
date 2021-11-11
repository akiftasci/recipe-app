package com.abn.recipes.controller;

import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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

    @GetMapping(value = "/get")
    public List<Recipe> getRecipes (){
        return recipesRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Recipe> persist(@RequestBody final Recipe recipe){
        recipesRepository.save(recipe);
        return recipesRepository.findAll();
    }
}

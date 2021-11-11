package com.abn.recipes.service;

import com.abn.recipes.model.Recipe;
import com.abn.recipes.repository.RecipesRepository;
import java.time.LocalDateTime;
import java.util.List;

public class RecipeService {
    RecipesRepository recipesRepository;

    public RecipeService(    RecipesRepository recipesRepository){
        this.recipesRepository = recipesRepository;

    }

    public static String convertDateFormat(final LocalDateTime created) {
        String formattedDate;
        final int day = created.getDayOfMonth();
        final int month = created.getMonthValue();
        final int year = created.getYear();
        final int hour = created.getHour();
        final int minute = created.getMinute();
        formattedDate = day +"-"+ month +"-"+ year +" "+ hour+":"+minute;
        return formattedDate;
    }

    public List<Recipe> getReceipts(){
        return recipesRepository.findAll();
    }
}

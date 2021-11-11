package com.abn.recipes.repository;

import com.abn.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipe, Integer> {
}

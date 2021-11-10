package com.abn.recipes.controller;

import com.abn.recipes.model.Recipe;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recepie/v1")
public class RecipeController {
    List<Recipe> recepies = Arrays.asList(
        new Recipe("111AAA","kofte", LocalDateTime.now(),false,2,"sa")
    );

    @GetMapping(value = "/get")
    public Recipe getString (){ return recepies.get(0);}
}

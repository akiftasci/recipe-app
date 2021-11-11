package com.abn.recipes.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeDto {

    private  Long id;
    private String name;
    private String date;
    private boolean vegetarian;
    private int portion;
    private List<IngredientDto> ingredients;


}

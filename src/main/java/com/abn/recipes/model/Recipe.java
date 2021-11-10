package com.abn.recipes.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Recipe {
    private String UUID;
    private String name;
    private LocalDateTime created;
    private boolean vegetarian;
    private int portion;
//    private List<String> ingredients;
    private String instructions;

    public Recipe(String UUID, String name, LocalDateTime created, boolean vegetarian, int portion , String instructions){
        this.UUID = UUID;
        this.name = name;
        this.created = created;
        this.vegetarian = vegetarian;
        this.portion = portion;
//        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}

package com.abn.recipes.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Setter
@Getter
@Builder
public class Recipe {
    @Id
//    @Column(name = "UUID")
//    private String UUID;
    @Column(name = "name")
    private String name;
//    @Column(name = "create_time")
//    private LocalDateTime created;
//    @Column(name = "vegetarian")
//    private boolean vegetarian;
//    @Column(name = "portion")
//    private int portion;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "instructions")
    private String instructions;

    public Recipe( String name, String ingredients, String instructions){
//        this.UUID = UUID;
        this.name = name;
//        this.created = created;
//        this.vegetarian = vegetarian;
//        this.portion = portion;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}

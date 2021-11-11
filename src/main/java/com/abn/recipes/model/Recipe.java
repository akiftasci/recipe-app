package com.abn.recipes.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "recipes")
@Setter
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "datetime")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "portion")
    private int portion;

    @OneToMany(mappedBy = "recipe", cascade= CascadeType.ALL)
    private List<Ingredient> ingredients;

    public  Recipe(){

    }
}

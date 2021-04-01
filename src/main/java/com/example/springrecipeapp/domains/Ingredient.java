package com.example.springrecipeapp.domains;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private BigDecimal amount;
    private String description;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Ingredient;
    }

}

package com.example.springrecipeapp.domains;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private BigDecimal amount;
    private String descripiton;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    public Long getId() {
        return id;
    }

    public Ingredient(){}

    public Ingredient(String descripiton, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.id = id;
        this.amount = amount;
        this.descripiton = descripiton;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}

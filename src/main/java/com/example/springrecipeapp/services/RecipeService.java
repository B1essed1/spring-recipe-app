package com.example.springrecipeapp.services;

import com.example.springrecipeapp.domains.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}

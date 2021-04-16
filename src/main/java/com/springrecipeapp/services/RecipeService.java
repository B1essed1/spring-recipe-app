package com.springrecipeapp.services;

import com.springrecipeapp.commands.RecipeCommand;
import com.springrecipeapp.domains.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);
}

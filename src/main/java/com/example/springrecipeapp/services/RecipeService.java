package com.example.springrecipeapp.services;

import com.example.springrecipeapp.commands.RecipeCommand;
import com.example.springrecipeapp.domains.Recipe;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findByID(Long l);

    @Transactional
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}

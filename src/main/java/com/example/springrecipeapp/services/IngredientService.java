package com.example.springrecipeapp.services;

import com.example.springrecipeapp.commands.IngredientCommand;

public interface IngredientService
{
    IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId);
}

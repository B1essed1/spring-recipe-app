package com.springrecipeapp.services;

import com.springrecipeapp.commands.IngredientCommand;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientService
{
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long id);
}

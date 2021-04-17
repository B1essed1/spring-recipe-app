package com.springrecipeapp.converters;


import com.springrecipeapp.commands.IngredientCommand;
import com.springrecipeapp.domains.Ingredient;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
@Slf4j
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());

        if (ingredient.getRecipe() != null)
        {
            ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        }

        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        if (ingredient.getUnitOfMeasure()!= null){

            ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUnitOfMeasure()));
        }
        else {
            log.error("#########something wrong happened");
            log.debug("#########something wrong happened");
        }
        return ingredientCommand;
    }
}

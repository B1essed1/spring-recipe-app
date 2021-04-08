package com.example.springrecipeapp.controllers;

import com.example.springrecipeapp.services.IngredientService;
import com.example.springrecipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController
{
 private final RecipeService recipeService;
 private final IngredientService ingredientService;
    public IngredientController(RecipeService recipeService , IngredientService ingredientService)
    {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listOfIngredients(@PathVariable String recipeId, Model model)
    {
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeId)));
        return "ingredients/list";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId ,
                                       @PathVariable String id, Model model)
    {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId),Long.valueOf(id)));

        return "ingredients/show";
    }


    
}

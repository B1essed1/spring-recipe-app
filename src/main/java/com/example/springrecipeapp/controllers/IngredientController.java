package com.example.springrecipeapp.controllers;

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
    public IngredientController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listOfIngredients(@PathVariable String recipeId, Model model)
    {
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(recipeId)));
        return "ingredients/list";
    }



    
}

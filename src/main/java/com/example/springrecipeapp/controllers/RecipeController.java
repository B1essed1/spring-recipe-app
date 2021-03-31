package com.example.springrecipeapp.controllers;


import com.example.springrecipeapp.commands.RecipeCommand;
import com.example.springrecipeapp.repositories.RecipeRepository;
import com.example.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController
{
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id , Model model)
    {
        model.addAttribute("recipe",recipeService.findByID(Long.valueOf(id)));
        return "recipe/show";
    }
/*
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command)
    {
        RecipeCommand recipeCommand = recipeService.saveRecipeCommand(command);
        System.out.println( recipeCommand.getNotes().getRecipeNotes());

        return "redirect:/recipe/show/"+recipeCommand.getId();
    }*/

}

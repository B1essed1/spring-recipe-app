package com.springrecipeapp.controllers;


import com.springrecipeapp.services.ImageService;
import com.springrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class imageController
{
    private final ImageService imageService;
    private final RecipeService recipeService;

    public imageController(ImageService imageServece, RecipeService recipeService) {
        this.imageService = imageServece;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/imageuploadform";
    }
    @PostMapping("recipe/{id}/image")
    public String handleImageForm(@PathVariable String id, @RequestParam("imagefile")MultipartFile file)
    {
        imageService.saveImageFile(Long.valueOf(id), file);
        return "redirect: /recipe/"+id+"/show";
    }
}

package com.springrecipeapp.controllers;


import com.springrecipeapp.commands.RecipeCommand;
import com.springrecipeapp.services.ImageService;
import com.springrecipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@Slf4j
public class ImageController
{
    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model)
    {
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));
        log.debug("$$$$$$$$$$$  recipe id $$$$$$$$$$$$$  :" + id);
        log.error("$$$$$$$$$$$  recipe id $$$$$$$$$$$$$  :" + id);

        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImageForm(@PathVariable String id, @RequestParam("uploadfile")MultipartFile file)
            throws IOException {
        imageService.saveImageFile(Long.valueOf(id), file);
        log.debug("############## Recipe Id must work ###############" + id);

        return "redirect:/recipe/"+id+"/show";
    }

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        RecipeCommand recipeCommand= recipeService.findCommandById(Long.valueOf(id));

        byte[] imageObj =  new byte[recipeCommand.getImage().length];

        int i = 0;
        for (byte b: recipeCommand.getImage())
        {
            imageObj[i++] = b;
        }

        response.setContentType("image/jpeg");
        InputStream is =new  ByteArrayInputStream(imageObj);
        IOUtils.copy(is, response.getOutputStream());

    }
}

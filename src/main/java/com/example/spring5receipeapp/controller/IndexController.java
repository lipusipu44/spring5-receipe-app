package com.example.spring5receipeapp.controller;

import com.example.spring5receipeapp.domain.Category;
import com.example.spring5receipeapp.domain.UnitOfMeasure;
import com.example.spring5receipeapp.repository.CategoryRepository;
import com.example.spring5receipeapp.repository.UnitOfMeasureRepository;
import com.example.spring5receipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/","","/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}

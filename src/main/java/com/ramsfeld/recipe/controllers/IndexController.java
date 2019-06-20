package com.ramsfeld.recipe.controllers;

import com.ramsfeld.recipe.domain.Category;
import com.ramsfeld.recipe.domain.UnitOfMeasure;
import com.ramsfeld.recipe.repositories.CategoryRepository;
import com.ramsfeld.recipe.repositories.UnitOfMeasureRepository;
import com.ramsfeld.recipe.serwices.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndex(Model model){

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat id: "+ category.get().getId());
        System.out.println("UnitOfMeasure id: "+unitOfMeasure.get().getId());

        model.addAttribute("recipes", recipeService.findAll());

        return "index";
    }
}

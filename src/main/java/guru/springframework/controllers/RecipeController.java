package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"recipe/show/{id}"})
    public String getRecipe(Model model,
                            @PathVariable ("id") long id){
        model.addAttribute("recipe", recipeService.findRecipesById(Long.valueOf(id)));
        model.addAttribute("categories", recipeService.findRecipesById(id).getCategories());
        model.addAttribute("note", recipeService.findRecipesById(id).getNotes());
        return "recipe/show";
    }
}

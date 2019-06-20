package com.ramsfeld.recipe.bootstrap;

import com.ramsfeld.recipe.domain.Difficulty;
import com.ramsfeld.recipe.domain.Ingredient;
import com.ramsfeld.recipe.domain.Recipe;
import com.ramsfeld.recipe.serwices.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;


@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeService recipeService;


    public DataLoader(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = recipeService.findAll().size();
        if(count == 0) {
            lodaData();
        }
    }

    private void lodaData() {
        Recipe guacamole = new Recipe();
        guacamole.setCookTime(20);
        guacamole.setDescription("The BEST guacamole!");
        guacamole.setDifficulty(Difficulty.HARD);
        guacamole.setPrepTime(30);
        Ingredient one = new Ingredient();
        one.setAmount(222212);



        recipeService.save(guacamole);



        Recipe grilledChickenTacos = new Recipe();
        grilledChickenTacos.setDescription("Grilled Chicken Tacos !");
        grilledChickenTacos.setCookTime(15);
        grilledChickenTacos.setDifficulty(Difficulty.EASY);
        grilledChickenTacos.setPrepTime(10);
        recipeService.save(grilledChickenTacos);
    }
}

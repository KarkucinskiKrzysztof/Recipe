package com.ramsfeld.recipe.serwices.map;

import com.ramsfeld.recipe.domain.Recipe;
import com.ramsfeld.recipe.serwices.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {
        @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Recipe save(Recipe object) {
        return super.save(object);
    }

    @Override
    public void delete(Recipe object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

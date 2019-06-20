package com.ramsfeld.recipe.repositories;

import com.ramsfeld.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecepieRepository extends CrudRepository<Recipe,Long> {

}

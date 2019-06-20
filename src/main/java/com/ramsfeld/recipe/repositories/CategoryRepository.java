package com.ramsfeld.recipe.repositories;

import com.ramsfeld.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

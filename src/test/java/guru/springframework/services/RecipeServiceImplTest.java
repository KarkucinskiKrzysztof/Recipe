package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;


public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);  // daj mi mock recipeRepository
        recipeService = new RecipeServiceImpl(recipeRepository);
    }


    @Test
    public void getRecipes()   {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipesData);  // mowimy kiedy zostanie wywołane recepiesRepo zwracaj recepiesData

        Set<Recipe> recipes = recipeService.getRecipes();  // mockito zwraca nam ty pusty set
        assertEquals(recipes.size(),1);
        assertNotEquals(recipes.size(),0);
        verify(recipeRepository, times(1)).findAll();    // ile razy zostało wywołane recipeRepositories ?
    }
}
package guru.springframework.services;

import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;  // impl bo testujemy dokładnie ten a nie zaden inny servis

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);  // daj mi mock recipeRepository (lub wiecej jeśli sa nne rzeczy sa zamokowane)
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand); // proste tworzenie obiektu RecipeServiceImpl zwykły konstruktor
    }

    @Test
    public void getRecipesByIdTest() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        // to nie jest sprawdzenie zachowania ale określenie jaki obikt repozytory ma zwracać przy konkretnym wywołaniu
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1l);
        Recipe recipeReturned1 = recipeService.findById(1l);
        Recipe recipeReturned3 = recipeService.findById(1l);

        Set<Recipe> sa = new HashSet<>();
        sa = recipeService.getRecipes();
        assertNotNull("Null recipe returned", recipeReturned);

        // zlicza ile razy dana  metoda z mocka recipeRepository została wywołana przez metode z servisu
        verify(recipeRepository, times(3)).findById(anyLong());
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).deleteAll();


    }

    @Test
    public void getRecipes() throws Exception {

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
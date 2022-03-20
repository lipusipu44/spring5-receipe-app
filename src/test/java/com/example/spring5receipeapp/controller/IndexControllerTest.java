package com.example.spring5receipeapp.controller;

import com.example.spring5receipeapp.domain.Recipe;
import com.example.spring5receipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        //given
        Set<Recipe> recipes=new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe=new Recipe();
        recipe.setId(2l);
        recipes.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);


        String index=indexController.getIndexPage(model);
        assertEquals("index",index);
        verify(recipeService,times(1)).getRecipes();
        //this recipes spelling has to be same as mentioned in the addAttribute() in IndexController class.
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());

        Set<Recipe> captorValue = argumentCaptor.getValue();
        assertEquals(2,captorValue.size());
    }
}
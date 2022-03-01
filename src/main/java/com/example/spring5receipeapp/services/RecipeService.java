package com.example.spring5receipeapp.services;

import com.example.spring5receipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}

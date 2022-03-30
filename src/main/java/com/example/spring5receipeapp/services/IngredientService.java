package com.example.spring5receipeapp.services;

import com.example.spring5receipeapp.command.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}

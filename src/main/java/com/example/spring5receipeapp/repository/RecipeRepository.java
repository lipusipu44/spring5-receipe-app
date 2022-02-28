package com.example.spring5receipeapp.repository;

import com.example.spring5receipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}

package com.example.spring5receipeapp.services;

import com.example.spring5receipeapp.command.RecipeCommand;
import com.example.spring5receipeapp.converters.RecipeCommandToRecipe;
import com.example.spring5receipeapp.converters.RecipeToRecipeCommand;
import com.example.spring5receipeapp.domain.Recipe;
import com.example.spring5receipeapp.exceptions.NotFoundException;
import com.example.spring5receipeapp.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("This is coming from lombok");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> byId = recipeRepository.findById(id);
        if (!byId.isPresent()){
            //throw new RuntimeException("Recipe not found !!!");
            throw new NotFoundException("Recipe not found for ID value:"+ id.toString());
        }
        return byId.get();
    }
    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id){
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe recipe=recipeCommandToRecipe.convert(command);
        Recipe savedObject=recipeRepository.save(recipe);
        log.info("Saved Recipe Id:"+savedObject.getId());
        return recipeToRecipeCommand.convert(savedObject);
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }


}

package com.example.spring5receipeapp.controller;

import com.example.spring5receipeapp.domain.Category;
import com.example.spring5receipeapp.domain.UnitOfMeasure;
import com.example.spring5receipeapp.repository.CategoryRepository;
import com.example.spring5receipeapp.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/","","/index"})
    public String getIndexPage(){
        Optional<Category> mexican = categoryRepository.findByDescription("Mexican");
        System.out.println("category by id:"+mexican.get().getId());

        Optional<Category> byId = categoryRepository.findById(1L);
        System.out.println("category found by id:"+byId.get().getDescription());

        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");
        System.out.println("Uom is:"+pinch.get().getId());



        return "index";
    }
}

package com.example.spring5receipeapp.domain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CategoryTest {
    Category category;
    @Before
    public void setUp(){
        category=new Category();
    }

    @Test
    public void getId() {
        Long idVal=4l;
        category.setId(idVal);
        assertEquals(idVal,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}
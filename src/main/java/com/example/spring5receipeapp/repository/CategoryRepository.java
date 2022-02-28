package com.example.spring5receipeapp.repository;

import com.example.spring5receipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}

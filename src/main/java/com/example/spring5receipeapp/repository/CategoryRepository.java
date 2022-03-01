package com.example.spring5receipeapp.repository;

import com.example.spring5receipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
    Optional<Category> findById(Long id);
}

package com.umbrella.cqrs.demo.service;

import com.umbrella.cqrs.demo.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category findById(String ID);

    Category save(Category category);

    void deleteById(String id);
}

package com.umbrella.cqrs.demo.repository;

import com.umbrella.cqrs.demo.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}

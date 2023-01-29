package com.umbrella.cqrs.demo.repository;

import com.umbrella.cqrs.demo.models.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<Brand, String> {
}

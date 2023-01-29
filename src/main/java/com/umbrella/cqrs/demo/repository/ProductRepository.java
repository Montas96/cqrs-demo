package com.umbrella.cqrs.demo.repository;

import com.umbrella.cqrs.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Page<Product> findAllByCategoryId(String categoryId, Pageable pageable);

    Page<Product> findAllByBrandId(String brandId, Pageable pageable);

}

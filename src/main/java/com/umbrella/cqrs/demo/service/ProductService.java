package com.umbrella.cqrs.demo.service;

import com.umbrella.cqrs.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getAllProducts(Pageable pageable);

    Page<Product> getAllProductsByCategoryId(String categoryId, Pageable pageable);

    Page<Product> getAllProductsByBrandId(String brandId, Pageable pageable);

    Product getProductById(String productId);

    Product save(Product product);

    void delete(String id);


}

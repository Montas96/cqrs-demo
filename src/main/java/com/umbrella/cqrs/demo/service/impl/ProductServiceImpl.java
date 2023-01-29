package com.umbrella.cqrs.demo.service.impl;

import com.umbrella.cqrs.demo.models.Product;
import com.umbrella.cqrs.demo.repository.ProductRepository;
import com.umbrella.cqrs.demo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllProductsByCategoryId(String categoryId, Pageable pageable) {
        return productRepository.findAllByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Product> getAllProductsByBrandId(String brandId, Pageable pageable) {
        return productRepository.findAllByBrandId(brandId, pageable);
    }

    @Override
    public Product getProductById(String productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        return optionalProduct.get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}

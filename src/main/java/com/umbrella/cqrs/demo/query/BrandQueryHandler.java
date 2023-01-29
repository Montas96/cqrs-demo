package com.umbrella.cqrs.demo.query;

import com.umbrella.cqrs.demo.models.Brand;
import com.umbrella.cqrs.demo.repository.BrandRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandQueryHandler {

    @Autowired
    BrandRepository brandRepository;

    @QueryHandler
    public List<Brand> getBrands(BrandQuery brandQuery) {
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }
}

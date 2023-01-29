package com.umbrella.cqrs.demo.service.impl;

import com.umbrella.cqrs.demo.models.Brand;
import com.umbrella.cqrs.demo.repository.BrandRepository;
import com.umbrella.cqrs.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(String ID) {
        Optional<Brand> optionalBrand = brandRepository.findById(ID);
        if (!optionalBrand.isPresent()) {
            throw new RuntimeException("Brand can not be found");
        }
        return optionalBrand.get();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(String id) {
        brandRepository.deleteById(id);
    }
}

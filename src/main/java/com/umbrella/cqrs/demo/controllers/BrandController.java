package com.umbrella.cqrs.demo.controllers;

import com.umbrella.cqrs.demo.models.Brand;
import com.umbrella.cqrs.demo.service.BrandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private CommandGateway commandGateway;
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getAll() {
        return brandService.getAllBrands();
    }

    @GetMapping("/brand/{id}")
    public Brand findOne(@PathVariable String id) {
        return brandService.findById(id);
    }

}

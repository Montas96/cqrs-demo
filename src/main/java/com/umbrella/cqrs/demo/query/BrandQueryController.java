package com.umbrella.cqrs.demo.query;

import com.umbrella.cqrs.demo.models.Brand;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandQueryController {

    /**
     * The QueryGateway interface and the DefaultQueryGateway implementation are provided by Axon.
     * The query gateway provides a number of methods for sending a query and waiting for one or more results synchronously,
     * with a timeout, or asynchronously.
     */
    @Autowired
    QueryGateway queryGateway;

    @GetMapping("/brands")
    public List<Brand> getEmployees() {
        BrandQuery brandQuery = new BrandQuery();
        return queryGateway.query(brandQuery, ResponseTypes.multipleInstancesOf(Brand.class)).join();
    }
}

package com.umbrella.cqrs.demo.eventhandler;

import com.umbrella.cqrs.demo.event.BrandCreatedEvent;
import com.umbrella.cqrs.demo.models.Brand;
import com.umbrella.cqrs.demo.repository.BrandRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandEventHandler {
    @Autowired
    private BrandRepository brandRepository;

    @EventHandler
    public void brandCreatedEvent(BrandCreatedEvent brandCreatedEvent){
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandCreatedEvent, brand);
        brandRepository.save(brand);
    }
}

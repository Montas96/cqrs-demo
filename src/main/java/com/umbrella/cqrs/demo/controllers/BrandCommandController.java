package com.umbrella.cqrs.demo.controllers;

import com.umbrella.cqrs.demo.command.CreateBrandCommand;
import com.umbrella.cqrs.demo.models.Brand;
import com.umbrella.cqrs.demo.service.BrandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BrandCommandController {

    /**
     * The CommandGateway allows us to deliver commands to Command Handler.
     */
    @Autowired
    private CommandGateway commandGateway;
    @Autowired
    private BrandService brandService;

    @PostMapping("/brand")
    public String create(@RequestBody Brand brand) {
        CreateBrandCommand createBrandCommand = new CreateBrandCommand(UUID.randomUUID().toString(), brand.getName(),brand.getCode());
        try {
            /**
             * sendAndWait(Object command) sends and waits for the provided command to be executed.
             * When the result of the execution is available, it is returned.
             */
            return commandGateway.sendAndWait(createBrandCommand);
        }catch (Exception exception){
            return exception.getMessage();
        }
    }


}

package com.umbrella.cqrs.demo.command.aggregator;

import com.umbrella.cqrs.demo.command.CreateBrandCommand;
import com.umbrella.cqrs.demo.event.BrandCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

/**
 * An aggregate is a self-contained tree of objects capable of processing commands.
 * Event Sourcing used to implement aggregates in Axon. An @AggregateIdentifier field must be present in an event source to aggregate.
 */
@Aggregate
public class BrandAggregate {

    //Unique identifier to aggregate
    /**
     * @AggregateIdentifier annotation signify that the class is Aggregator class.
     */
    @AggregateIdentifier
    private String uid;
    private String name;
    private String code;

    /**
     * Command Handler method to create employee object
     *
     * @param createBrandCommand
     */
    @CommandHandler
    public BrandAggregate(CreateBrandCommand createBrandCommand) {
        //Here we can handle validation logic on createEmployeeCommand object
        BrandCreatedEvent brandCreatedEvent = new BrandCreatedEvent();
        BeanUtils.copyProperties(createBrandCommand, brandCreatedEvent);

        /**
         * it invokes event source handler method (employeeEvent) with employee created event
         * AggregateLifecycle.apply, invokes event source handler method (employeeEvent) with employee created event.
         */
        AggregateLifecycle.apply(brandCreatedEvent);
    }

    /**
     * Method to store the EmployeeCreatedEvent in the eventstore
     *
     * @param brandCreatedEvent
     */
    @EventSourcingHandler
    public void brandEvent(BrandCreatedEvent brandCreatedEvent) {
        this.uid = brandCreatedEvent.getUid();
        this.name = brandCreatedEvent.getName();
        this.code = brandCreatedEvent.getCode();
    }
}

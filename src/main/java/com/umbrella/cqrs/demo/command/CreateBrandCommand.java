package com.umbrella.cqrs.demo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateBrandCommand {

    /**
     * The @TargetAggregateIdentifier annotation informs Axon that the annotated field
     * is an identifier for a specific aggregate to which the command should be sent.
     */
    @TargetAggregateIdentifier
    private String uid;

    private String id;
    private String name;
    private String code;


    public CreateBrandCommand() {
    }

    public CreateBrandCommand(String uid, String name, String code) {
        this.uid = uid;
        this.name = name;
        this.code = code;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.Test.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Clan {

    private UUID id;
    private String name;
    private String description;
    private List<Coder> coders = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Coder> getCoders() {
        return coders;
    }

    public void setCoders(List<Coder> coders) {
        this.coders = coders;
    }

}

package com.Test.demo.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Category {

    private UUID id;
    private String name;
    private Set<Coder> coders = new HashSet<>();

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

    public Set<Coder> getCoders() {
        return coders;
    }

    public void setCoders(Set<Coder> coders) {
        this.coders = coders;
    }

}

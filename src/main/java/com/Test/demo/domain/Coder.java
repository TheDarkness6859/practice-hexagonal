package com.Test.demo.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Coder {

    private UUID id;
    private String name;
    private Boolean active;
    private Clan clan;
    private Set<Category> categories = new HashSet<>();

    public Coder(UUID id, String name, Clan clan) {

        this.id = id;
        this.name = name;
        this.clan = clan;
        this.active = true;

    }

    public void desactivate () {
        this.active = false;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

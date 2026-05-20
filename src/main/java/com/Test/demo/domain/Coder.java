package com.Test.demo.domain;

import java.util.UUID;


public class Coder {

    private UUID id;
    private String name;
    private String clan;

    public Coder(UUID id, String name, String clan) {

        this.id = id;
        this.name = name;
        this.clan = clan;

    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}

package com.github.razum4e.spring.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Named extends Identifiable {
    private String name;
    private String description;

    public Named() {
    }

    public Named(long id) {
        super(id);
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
}

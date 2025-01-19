package com.github.razum4e.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity(name = "task_categories")
public class TaskCategory extends Named {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TaskCategorySet ident;

    public TaskCategory() {
    }

    public TaskCategory(long id) {
        super(id);
    }

    public TaskCategorySet getIdent() {
        return ident;
    }

    public void setIdent(TaskCategorySet ident) {
        this.ident = ident;
    }
}

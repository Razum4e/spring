package com.github.razum4e.spring.model;

import jakarta.persistence.Entity;

@Entity(name = "task_categories")
public class TaskCategory extends Named {

    public TaskCategory() {
    }

    public TaskCategory(long id) {
        super(id);
    }
}

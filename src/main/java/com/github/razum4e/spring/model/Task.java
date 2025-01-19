package com.github.razum4e.spring.model;

import jakarta.persistence.*;

@Entity(name = "tasks")
public class Task extends Named {
    @ManyToOne
    @JoinColumn(name = "task_category")
    private TaskCategory category;

    public Task() {
    }

    public Task(long id) {
        super(id);
    }

    public TaskCategory getCategory() {
        return category;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }
}

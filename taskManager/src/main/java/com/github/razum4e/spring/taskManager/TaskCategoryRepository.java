package com.github.razum4e.spring.taskManager;

import com.github.razum4e.spring.taskManager.model.TaskCategory;
import com.github.razum4e.spring.taskManager.model.TaskCategorySet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
    Optional<TaskCategory> findByIdent(TaskCategorySet ident);

    @Cacheable("task_categories")
    default TaskCategory getCategoryByEnum(TaskCategorySet ident) {
        return findByIdent(ident).orElseThrow(() ->
                new IllegalArgumentException("task category not found by ident: " + ident)
        );
    }
}

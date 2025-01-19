package com.github.razum4e.spring;

import com.github.razum4e.spring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

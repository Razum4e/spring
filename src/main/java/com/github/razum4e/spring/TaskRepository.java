package com.github.razum4e.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.razum4e.spring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

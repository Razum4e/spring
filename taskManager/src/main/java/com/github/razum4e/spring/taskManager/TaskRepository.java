package com.github.razum4e.spring.taskManager;

import com.github.razum4e.spring.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

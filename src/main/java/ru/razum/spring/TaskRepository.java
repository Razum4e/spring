package ru.razum.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.razum.spring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

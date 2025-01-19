package com.github.razum4e.spring;

import com.github.razum4e.spring.model.Task;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    private static final Sort DEFAULT_SORT_ORDER = Sort.by(Sort.Direction.DESC, "id");

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Task> tasks = taskRepository.findAll(DEFAULT_SORT_ORDER);
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String name, @RequestParam String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        taskRepository.save(task);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable long id, @RequestParam String name, @RequestParam String description) {
        taskRepository.findById(id)
                .ifPresent(task -> {
                    task.setName(name);
                    task.setDescription(description);
                    taskRepository.save(task);
                });
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}

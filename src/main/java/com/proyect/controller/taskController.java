package com.proyect.controller;

import com.proyect.model.itemTask;
import com.proyect.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private taskService taskService;

    @GetMapping
    public List<itemTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping(value = "/create")
    public itemTask createTask(@RequestBody itemTask task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public itemTask getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public itemTask updateTask(@PathVariable Long id, @RequestBody itemTask task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}

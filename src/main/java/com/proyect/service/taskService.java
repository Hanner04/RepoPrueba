package com.proyect.service;

import com.proyect.model.itemTask;
import com.proyect.repository.taskRepository;
import com.proyect.service.gateway.ItaksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taskService implements ItaksService {

    private final taskRepository taskRepository;

    @Autowired
    public taskService(taskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<itemTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public itemTask createTask(itemTask task) {
        return taskRepository.save(task);
    }

    @Override
    public itemTask getTaskById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Not found"));
    }

    @Override
    public itemTask updateTask(Long id, itemTask task) {
        itemTask existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}

package com.proyect.service.gateway;

import com.proyect.model.itemTask;

import java.util.List;

public interface ItaksService {
    public itemTask createTask(itemTask task);
    public List<itemTask> getAllTasks();
    public itemTask getTaskById(Long id);
    public itemTask updateTask(Long id, itemTask task);
    public void deleteTask(Long id);
}

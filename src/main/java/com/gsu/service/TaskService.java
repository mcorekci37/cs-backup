/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.service;

import com.gsu.model.Task;
import com.gsu.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atadam
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public TaskService(){}
    public void create(Task t){
        taskRepository.save(t);
    }
    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }
    public void update(Task t){
        taskRepository.save(t);
    }

}
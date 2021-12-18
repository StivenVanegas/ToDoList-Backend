package com.nevits.todolist.service;

import com.nevits.todolist.controller.task.TaskDto;
import com.nevits.todolist.repository.document.Task;

public interface TaskService {
    
    Task create(TaskDto taskDto);
    
    Task findById(String id);
    
    Task update( TaskDto taskDto, String id );
}

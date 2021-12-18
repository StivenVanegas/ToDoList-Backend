package com.nevits.todolist.repository.document;

import com.nevits.todolist.controller.task.TaskDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
    
    @Id
    String id;
    
    String name;
    
    String description;

    public Task() {
    }

    public Task(TaskDto taskDto) {
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void update(TaskDto taskDto) {
        if(taskDto.getName() != null)
            this.name = taskDto.getName();
        if(taskDto.getDescription() != null)
            this.description = taskDto.getDescription();
    }
    
}

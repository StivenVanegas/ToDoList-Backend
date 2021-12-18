
package com.nevits.todolist.service;

import com.nevits.todolist.controller.task.TaskDto;
import com.nevits.todolist.repository.TaskRepository;
import com.nevits.todolist.repository.document.Task;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceMongoDB implements TaskService{
    
    private final TaskRepository taskRepository;

    public TaskServiceMongoDB(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(TaskDto taskDto) {
        return taskRepository.save(new Task(taskDto));
    }

    @Override
    public Task findById(String id) {
        Optional<Task> optionalTask = taskRepository.findById( id );
        if ( optionalTask.isPresent() ){
            return optionalTask.get();
        } else{
            return null;
        }
    }

    @Override
    public Task update(TaskDto taskDto, String id) {
        if ( taskRepository.findById( id ).isPresent() ){
            Task task = taskRepository.findById( id ).get();
            task.update( taskDto );
            taskRepository.save( task );
            return task;
        }
        return null;
    }
     
}

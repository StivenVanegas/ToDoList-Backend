package com.nevits.todolist.controller.task;

import com.nevits.todolist.repository.document.Task;
import com.nevits.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping( "/v1/task" )
public class TaskController {
    
    private final TaskService taskService;

    public TaskController( @Autowired TaskService taskService ){
        this.taskService = taskService;
    }
    
    @PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto ){
        return ResponseEntity.ok( taskService.create( taskDto ) );
    }
    
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id ){
        return ResponseEntity.ok( taskService.update( taskDto, id ) );
    }
}

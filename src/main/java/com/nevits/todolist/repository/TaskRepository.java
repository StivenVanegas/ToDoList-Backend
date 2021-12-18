package com.nevits.todolist.repository;

import com.nevits.todolist.repository.document.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String>{
    
}

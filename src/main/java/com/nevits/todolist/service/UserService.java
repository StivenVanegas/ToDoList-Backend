package com.nevits.todolist.service;

import com.nevits.todolist.controller.user.UserDto;
import com.nevits.todolist.exception.UserNotFoundException;
import com.nevits.todolist.repository.document.Task;
import com.nevits.todolist.repository.document.User;
import java.util.List;

public interface UserService {
    
    User create( UserDto userDto );
    
    User update( UserDto userDto, String id );
    
    User findByUsername( String username ) throws UserNotFoundException;

    List<Task> getTasks(String id) throws UserNotFoundException;
}

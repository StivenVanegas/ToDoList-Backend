package com.nevits.todolist.controller.user;

import com.nevits.todolist.repository.document.Task;
import com.nevits.todolist.repository.document.User;
import com.nevits.todolist.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping( "/v1/user" )
public class UserController {
    
    private final UserService userService;

    public UserController( @Autowired UserService userService ){
        this.userService = userService;
    }
    
    @GetMapping("/tasks/{id}")
    public List<Task> getTasks(@PathVariable String id){
        return userService.getTasks(id);
    }
    
    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ){
        return ResponseEntity.ok( userService.create( userDto ) );
    }
    
    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ){
        return ResponseEntity.ok( userService.update( userDto, id ) );
    }
    
}

package com.nevits.todolist.repository.document;

import com.nevits.todolist.controller.user.UserDto;
import com.nevits.todolist.utils.RoleEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
public class User {
    
    @Id
    String id;
    
    @Indexed( unique = true )
    String username;
    
    String passwordHash;
    
    @DBRef
    List<Task> tasks;

    List<RoleEnum> roles;

    public User() {
    }
    
    public User(UserDto userDto) {
        this.username = userDto.getUsername();
        this.passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        this.tasks = new ArrayList();
        this.roles = new ArrayList<>( Collections.singleton( RoleEnum.USER ) );
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public void update(UserDto userDto) {
        if(userDto.getUsername() != null)
            this.username = userDto.getUsername();
        if(userDto.getPassword() != null)
            this.passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        if(userDto.getTasks() != null)
            this.tasks = userDto.getTasks();
    }
    
    
}

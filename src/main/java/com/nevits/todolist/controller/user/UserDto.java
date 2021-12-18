package com.nevits.todolist.controller.user;

import com.nevits.todolist.repository.document.Task;
import java.util.List;

public class UserDto {
    
    String username;
    String password;
    List<Task> tasks;

    public UserDto() {
    }

    public UserDto(String username, String password, List<Task> tasks) {
        this.username = username;
        this.password = password;
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
}

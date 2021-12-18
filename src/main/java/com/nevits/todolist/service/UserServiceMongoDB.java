package com.nevits.todolist.service;

import com.nevits.todolist.controller.user.UserDto;
import com.nevits.todolist.exception.UserNotFoundException;
import com.nevits.todolist.repository.UserRepository;
import com.nevits.todolist.repository.document.Task;
import com.nevits.todolist.repository.document.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMongoDB implements UserService{
    
    private final UserRepository userRepository;

    public UserServiceMongoDB( @Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserDto userDto) {
        return userRepository.save(new User(userDto));
    }

    @Override
    public User update(UserDto userDto, String id) {
        if ( userRepository.findById( id ).isPresent() ){
            User user = userRepository.findById( id ).get();
            user.update( userDto );
            userRepository.save( user );
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername( username );
        if ( optionalUser.isPresent() ){
            return optionalUser.get();
        } else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<Task> getTasks(String id) throws UserNotFoundException{
        if ( userRepository.findById( id ).isPresent() ){
            User user = userRepository.findById( id ).get();
            return user.getTasks();
        } else {
            throw new UserNotFoundException();
        }
    }
}

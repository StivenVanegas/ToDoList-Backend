package com.nevits.todolist.repository;

import com.nevits.todolist.repository.document.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
 
    Optional<User> findByUsername( String username );
}

package com.nevits.todolist.exception;

import com.nevits.todolist.error.ErrorCodeEnum;
import com.nevits.todolist.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends InternalServerErrorException{
    
    public UserNotFoundException(){
        super( new ServerErrorResponseDto( "User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND ),
               HttpStatus.NOT_FOUND );
    }
}

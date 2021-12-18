package com.nevits.todolist.exception;

import com.nevits.todolist.error.ErrorCodeEnum;
import com.nevits.todolist.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends InternalServerErrorException{
    
    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto("Invalid username or password", ErrorCodeEnum.INVALID_USER_CREDENTIALS,
                HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }
}

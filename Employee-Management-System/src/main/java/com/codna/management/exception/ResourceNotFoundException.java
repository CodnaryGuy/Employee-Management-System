package com.codna.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * To handle the custom exceptions
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}

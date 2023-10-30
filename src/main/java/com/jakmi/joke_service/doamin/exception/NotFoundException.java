package com.jakmi.joke_service.doamin.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(final String message){
        super(message);
    }
}

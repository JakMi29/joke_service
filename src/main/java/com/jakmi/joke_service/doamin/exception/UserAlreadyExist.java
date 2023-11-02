package com.jakmi.joke_service.doamin.exception;

public class UserAlreadyExist extends RuntimeException{

    public UserAlreadyExist(final String message){
        super(message);
    }
}

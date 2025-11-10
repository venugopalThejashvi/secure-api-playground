package com.care.predict.exception.custom;

public class UserAlreadyPresentException extends RuntimeException {
    public UserAlreadyPresentException(String message){
        super(message);
    }
}

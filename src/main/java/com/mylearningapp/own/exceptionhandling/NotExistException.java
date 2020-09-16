package com.mylearningapp.own.exceptionhandling;

public class NotExistException extends RuntimeException {

    public NotExistException(){
        super();
    }

    public NotExistException(String message){
        super(message);
    }
}

package com.mylearningapp.own.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.NotSerializableException;
import java.sql.SQLDataException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(SQLDataException.class)
    public ResponseEntity<String> SqlExceptionHandler(Exception e){
    return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> ElementExceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
    @ExceptionHandler(NotSerializableException.class)
    public ResponseEntity<String> CacheExceptionHandler(Exception e){
        return new ResponseEntity<>("Cache Write Serialization Error", HttpStatus.EXPECTATION_FAILED);
    }


}

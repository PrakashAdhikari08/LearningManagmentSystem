package com.mylearningapp.own.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1/")
public class UserController {

    @GetMapping("hello-user")
    public ResponseEntity<String> getAllUser(){
        return new ResponseEntity<>("Hello from all user", HttpStatus.OK);
    }
}

package com.mylearningapp.own.controller;

import com.mylearningapp.own.dtos.ContactUsDto;
import com.mylearningapp.own.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1/")
public class UserController {

    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("hello-user")
    public ResponseEntity<String> getAllUser(){
        return new ResponseEntity<>("Hello from all user", HttpStatus.OK);
    }


    @PostMapping("/contact")
    public ResponseEntity<String> userContactedUs(@RequestBody ContactUsDto contactUsDto){
        contactUsService.userContact(contactUsDto);
        return new ResponseEntity<>("Thanks for Contact", HttpStatus.OK);
    }
}

package com.mylearningapp.own.controller;

import com.mylearningapp.own.dtos.ContactUsDto;
import com.mylearningapp.own.security.jwt.AuthenticationRequest;
import com.mylearningapp.own.service.ContactUsService;
import com.mylearningapp.own.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private ContactUsService contactUsService;

    @Autowired
    private UserService userService;

    @GetMapping("hello-user")
    public ResponseEntity<String> getAllUser(){
        return new ResponseEntity<>("Hello from all user", HttpStatus.OK);
    }


    @PostMapping("/contact")
    public ResponseEntity<String> userContactedUs(@RequestBody ContactUsDto contactUsDto){
        contactUsService.userContact(contactUsDto);
        return new ResponseEntity<>("Thanks for Contact", HttpStatus.OK);
    }

    @GetMapping("/forgot-password-request")
    public ResponseEntity<String> forgotPasswordRequest(@RequestParam String email){
        userService.forgotPasswordRequest(email);
        return new ResponseEntity<>("Email Sent to You", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestParam String token, @RequestBody AuthenticationRequest authenticationRequest){
        userService.changePassword(token, new BCryptPasswordEncoder().encode(authenticationRequest.getPassword()));
        return new ResponseEntity<>("Password Change",HttpStatus.OK);
    }
}

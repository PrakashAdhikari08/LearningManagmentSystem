package com.mylearningapp.own.service;

public interface UserService {
    void forgotPasswordRequest(String email);

    void changePassword(String token, String password);
}

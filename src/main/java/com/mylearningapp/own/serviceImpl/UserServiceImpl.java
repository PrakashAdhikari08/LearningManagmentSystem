package com.mylearningapp.own.serviceImpl;

import com.mylearningapp.own.domain.User;
import com.mylearningapp.own.exceptionhandling.NotExistException;
import com.mylearningapp.own.mailservice.EmailSender;
import com.mylearningapp.own.repository.UserRepository;
import com.mylearningapp.own.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void forgotPasswordRequest(String email) {
        Optional<User> user = userRepository.findByUsername(email);
        user.orElseThrow(()-> new NotExistException("Username not found"));

        user.get().setResetToken(UUID.randomUUID().toString());
        emailSender.sendPasswordResetMail(user.get().getUsername(), user.get().getResetToken());
    }

    @Override
    @Transactional
    public void changePassword(String token, String password) {
        Optional<User> user = userRepository.findByResetToken(token);
        user.orElseThrow(()-> new RuntimeException("Token Mismatch"));
        user.get().setPassword(password);
        emailSender.sendThanksForPasswordChange(user.get().getUsername(),user.get().getName());
    }
}

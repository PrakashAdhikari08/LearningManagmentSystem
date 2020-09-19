package com.mylearningapp.own.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@EnableAsync

public class EmailSender {

    @Autowired
    private JavaMailSender emailSender;

    @Async
    public void sendPasswordResetMail(
            String username,String token) {
        String text = "To reset your password, Click the link below: \n"
                +"http://localhost:3000/user/reset-password/" +token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ftech977@gmail.com");
        message.setTo(username);
        message.setSubject("Password Reset Link");
        message.setText(text);
        emailSender.send(message);
    }
    @Async
    public void sendThanksForContactUs (String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ftech977@gmail.com");
        message.setTo(to);
        message.setSubject("Your enquiry is received");
        message.setText("Hello "+name+"," +"\nThanks for contacting us.\nWe will get back to you soon."+"\n\nRegards,\nTeam HacerCode");
        emailSender.send(message);
    }
    public void sendThanksForPasswordChange (String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ftech977@gmail.com");
        message.setTo(to);
        message.setSubject("Password Changed");
        message.setText("Hello "+name+"," +"\nYour Password has been changed.\nYou can login with your new Password."+"\n\nRegards,\nTeam HacerCode");
        emailSender.send(message);
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("ftech977@gmail.com");
        mailSender.setPassword("KathmanduNepal");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");

        return mailSender;
    }
}

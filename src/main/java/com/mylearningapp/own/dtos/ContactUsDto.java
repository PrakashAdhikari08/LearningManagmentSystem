package com.mylearningapp.own.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContactUsDto {

    @NotNull(message = "Please enter the name")
    private String name;

    @NotNull(message = "Please enter the email address")
    private String email;

    private String message;


}

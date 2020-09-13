package com.mylearningapp.own.dtos;

import lombok.Data;

import javax.persistence.GeneratedValue;

@Data
public class AdminDto extends UserDto{

    private String position;

    private String department;
}

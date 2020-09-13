package com.mylearningapp.own.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends UserDto{


    private String userType;

    private String faculty;

    private String description;
}

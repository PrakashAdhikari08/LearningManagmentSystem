package com.mylearningapp.own.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mylearningapp.own.domain.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UserDto {


    private Long id;

    private String firstName;

    private String lastName;

    @NotNull(message = "Please enter email")
    private String email;

    private String address;

    private String phone;

    @Size(max = 50, min = 8, message = "Password Must be between 8 to 50 characters")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private Boolean flag;

    private String resetToken;

    private String registerToken;

    private Role role;


    }


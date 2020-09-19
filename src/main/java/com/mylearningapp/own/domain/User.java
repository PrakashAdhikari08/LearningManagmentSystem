package com.mylearningapp.own.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name="username",unique = true, updatable = false)
    private String username;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name="password")
    private String password;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="reset_token")
    private String resetToken;

    @Column(name="register_token")
    private String registerToken;

    @Column(name="flag")
    private Boolean flag;


}

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

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email",unique = true, updatable = false)
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="role")
    private Role role;


}

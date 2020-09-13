package com.mylearningapp.own.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    @Column(name="user_type")
    private String userType;

    @Column(name="faculty")
    private String faculty;

    @Column(name="description")
    private String description;

    @ManyToMany
    private List<Course> course;

}

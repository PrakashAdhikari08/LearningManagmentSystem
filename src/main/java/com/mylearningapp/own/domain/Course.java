package com.mylearningapp.own.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_details")
    private String details;

    @Column(name = "course_duration")
    private String duration;


    public Course(Integer courseId) {
        this.id = courseId;
    }

//    @ManyToMany
//    private List<Customer> customer;


}

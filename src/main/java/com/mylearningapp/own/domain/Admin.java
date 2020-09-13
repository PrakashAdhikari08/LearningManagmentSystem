package com.mylearningapp.own.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Admin extends User{

    @Column(name="position")
    private String position;
}

package com.mylearningapp.own.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class CourseDto implements Serializable {

    private Integer id;

    @NotNull(message = "Course name is missing. Please Provide.")
    private String name;

    private String details;

    private String duration;
}

package com.mylearningapp.own.service;

import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.dtos.CustomerDto;

import java.util.List;

public interface CourseService  {
    Integer addCourse(CourseDto courseDto);

    List<CourseDto> getAllCourse();

    void deleteCourse(Integer courseId);

}

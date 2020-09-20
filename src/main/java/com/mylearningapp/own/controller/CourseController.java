package com.mylearningapp.own.controller;


import com.mylearningapp.own.domain.Course;
import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.dtos.CustomerDto;
import com.mylearningapp.own.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/v1/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("add")
    public ResponseEntity<String> addCourse(@RequestBody CourseDto courseDto){
        courseService.addCourse(courseDto);
        return new ResponseEntity<>("Course Created", HttpStatus.CREATED);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCourse(@RequestParam Integer courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>("Course Removed", HttpStatus.OK);
    }


    @GetMapping("all")
    public List<CourseDto> getAllCourse(){
       return courseService.getAllCourse();
    }

    @GetMapping("/page")
    public List<CourseDto> getCourseByPage(@RequestParam Integer pageNumber,@RequestParam Integer coursePerPage){
        return courseService.getCourseByPage(pageNumber, coursePerPage);
    }



}

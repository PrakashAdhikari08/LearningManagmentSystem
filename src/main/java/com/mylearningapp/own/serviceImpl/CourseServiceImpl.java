package com.mylearningapp.own.serviceImpl;

import com.mylearningapp.own.domain.Course;
import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.mapper.CourseMapper;
import com.mylearningapp.own.repository.CourseRepository;
import com.mylearningapp.own.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Transactional
    public Integer addCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        courseRepository.save(course);
        return course.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = courseMapper.toDtoList(courses);
        return courseDtos;
    }

    @Override
    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getCourseByPage(Integer pageNumber, Integer coursePerPage) {
        Pageable pageable = PageRequest.of(pageNumber-1,coursePerPage);
        List<Course> courses = courseRepository.findAllByOrderByIdDesc(pageable);
        List<CourseDto> courseDtos = courseMapper.toDtoList((List<Course>) courses);
        return courseDtos;
    }


}

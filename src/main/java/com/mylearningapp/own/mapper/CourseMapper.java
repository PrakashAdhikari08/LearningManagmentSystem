package com.mylearningapp.own.mapper;

import com.mylearningapp.own.domain.Course;
import com.mylearningapp.own.dtos.CourseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseDto courseDto);

    List<Course> toEntityList(List<CourseDto> courseDtos);

    CourseDto toDto(Course course);

    List<CourseDto> toDtoList(List<Course> courses);
}

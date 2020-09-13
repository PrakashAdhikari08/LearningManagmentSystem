package com.mylearningapp.own.service;

import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    Long registerCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    List<CustomerDto> getAllCustomerByCourse(Integer courseId);

    List<CourseDto> getAllCourseCustomer(Long customerId);

    void enrollCourse(Long customerId, Integer courseId);

    void deleteCustomer(Long customerId);
}

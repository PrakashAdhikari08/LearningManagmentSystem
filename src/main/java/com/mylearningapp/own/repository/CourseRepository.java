package com.mylearningapp.own.repository;

import com.mylearningapp.own.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

//    List<Course> findAllByCustomerId(Long customerId);
//
//    @Query(value = "DELETE FROM Course_Customer cc where  cc.customerId=:customerId",nativeQuery = true)
//    Void deleteCourseCustomer(@Param("customerId") Long customerId);
}

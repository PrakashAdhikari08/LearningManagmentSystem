package com.mylearningapp.own.repository;

import com.mylearningapp.own.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByCourseId(Integer courseId);
}

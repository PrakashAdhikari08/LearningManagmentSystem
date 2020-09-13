package com.mylearningapp.own.controller;

import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.dtos.CustomerDto;
import com.mylearningapp.own.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer/v1/")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<String> addNewCustomer(@Valid  @RequestBody CustomerDto customerDto){
        customerService.registerCustomer(customerDto);
        return new ResponseEntity<>("Customer Added", HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<CustomerDto> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("all/by-course")
    public List<CustomerDto> getAllCustomerByCourse(@RequestParam Integer courseId){
        return customerService.getAllCustomerByCourse(courseId);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer Deleted", HttpStatus.OK);
    }

    @GetMapping("enroll/{customerId}/{courseId}")
    public ResponseEntity<String> enrollCourse(@PathVariable Long customerId, @PathVariable Integer courseId){
        customerService.enrollCourse(customerId, courseId);
        return new ResponseEntity<>("Course Enrolled", HttpStatus.OK);
    }

    @GetMapping("all-course-customer")
    public List<CourseDto> customerDtos(@RequestParam Long customerId){
        return customerService.getAllCourseCustomer(customerId);
    }

    @GetMapping("resend-validation/find-by-email")
    public ResponseEntity<String> resendValidationEmail(@RequestParam String email){
        customerService.resendValidationEmail(email);
        return new ResponseEntity<>("Email Send", HttpStatus.OK);
    }

}

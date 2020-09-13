package com.mylearningapp.own.serviceImpl;

import com.mylearningapp.own.domain.Course;
import com.mylearningapp.own.domain.Customer;
import com.mylearningapp.own.domain.Role;
import com.mylearningapp.own.dtos.CourseDto;
import com.mylearningapp.own.dtos.CustomerDto;
import com.mylearningapp.own.exceptionhandling.NotExistException;
import com.mylearningapp.own.mapper.CourseMapper;
import com.mylearningapp.own.mapper.CustomerMapper;
import com.mylearningapp.own.repository.CourseRepository;
import com.mylearningapp.own.repository.CustomerRepository;
import com.mylearningapp.own.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    @Transactional
    public Long registerCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setFlag(false);
        customer.setResetToken(UUID.randomUUID().toString());
        customer.setRegisterToken(UUID.randomUUID().toString());
        //send email with the registered UUID to the Same Email Address
        customerRepository.save(customer);
        return customer.getId();
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = customerMapper.toDtoList(customers);
        return customerDtos;
    }

    @Override
//    @Cacheable(value = "formData",key = "#courseId")
    public List<CustomerDto> getAllCustomerByCourse(Integer courseId) {
        List<Customer> customers = customerRepository.findAllByCourseId(courseId);
        List<CustomerDto> customerDtos = customerMapper.toDtoList(customers);
        return customerDtos;
     }

    @Override
    @Transactional
//    @CacheEvict(value = "formData",key = "#courseId")
    public void enrollCourse(Long customerId, Integer courseId) {
       Customer customer = customerRepository.findById(customerId).get();
       customer.getCourse().add(new Course(courseId));
    }
    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourseCustomer(Long customerId) {
        List<Course> courses = customerRepository.findById(customerId).get().getCourse();
        List<CourseDto> courseDtos = courseMapper.toDtoList(courses);
        return courseDtos;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void resendValidationEmail(String email) {
       Optional<Customer> customer = customerRepository.findByEmail(email);

       customer.orElseThrow(()->new NotExistException("No Email Id exists"));

        System.out.println(customer);
    }
}

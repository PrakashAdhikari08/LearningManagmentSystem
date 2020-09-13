package com.mylearningapp.own.mapper;

import com.mylearningapp.own.domain.Customer;
import com.mylearningapp.own.dtos.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerDto customerDto);

    List<Customer> toEntityList(List<CustomerDto> customerDtoList);

    CustomerDto toDto(Customer customer);

    List<CustomerDto> toDtoList(List<Customer> customers);

}

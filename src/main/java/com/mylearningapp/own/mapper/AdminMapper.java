package com.mylearningapp.own.mapper;

import com.mylearningapp.own.domain.Admin;
import com.mylearningapp.own.domain.User;
import com.mylearningapp.own.dtos.AdminDto;
import com.mylearningapp.own.dtos.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper  {

    AdminDto toDto(Admin admin);

    List<AdminDto> toDtoList(List<Admin> admins);

    Admin toEntity(AdminDto adminDto);

    List<Admin> toEntityList(List<AdminDto> adminDtos);
}

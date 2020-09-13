package com.mylearningapp.own.mapper;

import com.mylearningapp.own.domain.User;
import com.mylearningapp.own.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    User toEntity(UserDto userDto);

    List<User> toEntityList(List<UserDto> userDtos);

}

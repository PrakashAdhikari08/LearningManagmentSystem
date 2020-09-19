package com.mylearningapp.own.mapper;

import com.mylearningapp.own.contact.ContactUsEntity;
import com.mylearningapp.own.dtos.ContactUsDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ContactUsMapper {

    ContactUsEntity toEntity(ContactUsDto contactUsDto);

    ContactUsDto toDto(ContactUsEntity contactUsEntity);

    List<ContactUsEntity> toEntityList(List<ContactUsDto> contactUsDtoList);

    List<ContactUsDto> toDtoList(List<ContactUsEntity> contactUsEntitiesList);

}

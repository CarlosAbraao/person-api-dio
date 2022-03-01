package com.carlosdev.personApi.personApi.mapper;

import com.carlosdev.personApi.personApi.dto.request.PersonDTO;
import com.carlosdev.personApi.personApi.entities.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTACE   = Mappers.getMapper(PersonMapper.class);

   @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy"  )
    Person toModel(PersonDTO personDTO);
    PersonDTO toDto(Person person);

}

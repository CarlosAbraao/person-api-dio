package com.carlosdev.personApi.personApi.service;


import com.carlosdev.personApi.personApi.dto.MessageResponseDTO;
import com.carlosdev.personApi.personApi.dto.request.PersonDTO;
import com.carlosdev.personApi.personApi.entities.Person;
import com.carlosdev.personApi.personApi.mapper.PersonMapper;
import com.carlosdev.personApi.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
// CLASSE RESPONSAVEL PELAS REGRAS DE NEGOCIO

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTACE;

    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }
}

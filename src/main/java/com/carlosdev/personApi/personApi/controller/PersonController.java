package com.carlosdev.personApi.personApi.controller;

import com.carlosdev.personApi.personApi.dto.MessageResponseDTO;
import com.carlosdev.personApi.personApi.dto.request.PersonDTO;
import com.carlosdev.personApi.personApi.entities.Person;
import com.carlosdev.personApi.personApi.repository.PersonRepository;
import com.carlosdev.personApi.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping ("/api/v1/people")
public class PersonController {



    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;



    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }
}

package com.carlosdev.personApi.personApi.controller;

import com.carlosdev.personApi.personApi.dto.MessageResponseDTO;
import com.carlosdev.personApi.personApi.dto.request.PersonDTO;
import com.carlosdev.personApi.personApi.entities.Person;
import com.carlosdev.personApi.personApi.repository.PersonRepository;
import com.carlosdev.personApi.personApi.service.PersonService;
import com.carlosdev.personApi.personApi.service.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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
    @GetMapping
    public List<PersonDTO> listAll(){

       return personService.listAll();

    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);


    }
}

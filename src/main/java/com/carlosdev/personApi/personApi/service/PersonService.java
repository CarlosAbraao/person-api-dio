package com.carlosdev.personApi.personApi.service;


import com.carlosdev.personApi.personApi.dto.MessageResponseDTO;
import com.carlosdev.personApi.personApi.dto.request.PersonDTO;
import com.carlosdev.personApi.personApi.entities.Person;
import com.carlosdev.personApi.personApi.mapper.PersonMapper;
import com.carlosdev.personApi.personApi.repository.PersonRepository;
import com.carlosdev.personApi.personApi.service.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
// CLASSE RESPONSAVEL PELAS REGRAS DE NEGOCIO

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTACE;

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        //REFATORANDO CODIGO -> VOU SUBSTITUIR ESSA LINHA PELA DE CIMA
        // Optional<Person> optionalPerson = personRepository.findById(id);


        // COM A INCLUS??O DO "ORELSE" POSSO TIRAR A LINHA DE BAIXO COMENTADA
        //if (optionalPerson.isEmpty()){
        // throw new PersonNotFoundException(id);

        //NESSE CASO POSSO PASSAR DIRETO A PESSOA
        //return personMapper.toDto(optionalPerson.get());
        return personMapper.toDto(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);


        personRepository.deleteById(id);

    }

    //VERIFICAR SE O ID EXISTE

    private Person verifyIfExists(Long id ) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }



}
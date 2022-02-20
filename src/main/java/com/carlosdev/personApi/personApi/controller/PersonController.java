package com.carlosdev.personApi.personApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TESTE DE COMMIT
@RestController
@RequestMapping ("/api/v1/people")
public class PersonController {

    @GetMapping
    public String getbook(){
        return "api Test"; sdsdsdsdssd
    }
}

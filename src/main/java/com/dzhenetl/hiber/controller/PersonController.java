package com.dzhenetl.hiber.controller;


import com.dzhenetl.hiber.entity.Person;
import com.dzhenetl.hiber.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}

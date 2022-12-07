package com.dzhenetl.hiber.controller;


import com.dzhenetl.hiber.entity.Person;
import com.dzhenetl.hiber.repository.PersonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.findAllByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonsByCity(@RequestParam Integer age) {
        List<Person> persons = repository.findByAgeLessThan(Sort.by("age"), age);
        persons.sort(Comparator.comparingInt(Person::getAge));
        return persons;
    }

    @GetMapping("/by-name-and-surname")
    public Person getPersonByNameAndSurname(@RequestParam String name,
                                            @RequestParam String surname) {
        return repository.findByNameIsAndSurnameIs(name, surname).orElseThrow(RuntimeException::new);
    }
}

package com.dzhenetl.hiber.repository;

import com.dzhenetl.hiber.entity.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findAllByCityOfLiving(String city);

    List<Person> findByAgeLessThan(Sort sort, Integer age);

    Optional<Person> findByNameIsAndSurnameIs(String name, String surname);
}

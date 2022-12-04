package com.dzhenetl.hiber.repository;

import com.dzhenetl.hiber.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Person> getPersonsByCity(String city) {
        Query query = manager.createQuery("select p from Person p where p.cityOfLiving = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }
}

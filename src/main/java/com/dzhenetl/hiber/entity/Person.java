package com.dzhenetl.hiber.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
public class Person {

    @EmbeddedId
    private PersonId personId;
    private String phoneNumber;
    private String cityOfLiving;
}

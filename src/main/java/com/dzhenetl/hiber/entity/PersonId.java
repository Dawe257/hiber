package com.dzhenetl.hiber.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private Integer age;
}

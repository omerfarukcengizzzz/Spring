package com.cybertek.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

//    OPTION 1: Address is the super class
    @ManyToOne
    private Person person;

}

package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int id;     // primary key on db

    private String make;
    private String model;

}

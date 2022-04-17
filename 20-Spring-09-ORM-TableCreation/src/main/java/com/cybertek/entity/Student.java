package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName", length = 50, nullable = false)
    private String firstName;
    private String lastName;
    private String email;

}

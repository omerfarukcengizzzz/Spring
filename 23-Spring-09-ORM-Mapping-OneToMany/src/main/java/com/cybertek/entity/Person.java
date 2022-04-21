package com.cybertek.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

//    OPTION 1: Address is the super class
    // if we map with @ManyToOne from Address class, we don't need to map it from here. (we don't need these lines)
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

//    OPTION 2: not preferred
//    @OneToMany
//    @JoinColumn(name = "person_id")
//    private List<Address> addresses;

}

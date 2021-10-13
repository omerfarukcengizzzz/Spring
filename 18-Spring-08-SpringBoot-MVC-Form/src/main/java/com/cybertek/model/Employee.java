package com.cybertek.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private int date;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private int zipCode;

}

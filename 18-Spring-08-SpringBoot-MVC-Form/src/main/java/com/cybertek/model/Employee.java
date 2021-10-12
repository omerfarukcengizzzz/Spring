package com.cybertek.model;

import com.cybertek.enums.State;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    // private Calendar calendar;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private State state;
    private int zipCode;

}

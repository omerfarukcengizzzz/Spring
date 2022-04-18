package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department {

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String division;

}

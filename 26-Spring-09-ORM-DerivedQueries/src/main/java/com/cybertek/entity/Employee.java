package com.cybertek.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;



}

package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int salary;

}

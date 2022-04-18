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
public class Employee {

    public Employee(String firstName, String lastName, String email, Date hireDate, Gender gender, Long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long salary;

}

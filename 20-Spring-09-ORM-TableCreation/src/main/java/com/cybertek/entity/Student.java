package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName", length = 50, nullable = false)
    private String firstName;
    private String lastName;
    private String email;

    @Transient  // used in order not to see the object on table
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;
    @Column(columnDefinition = "TIME")
    private LocalTime localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(String firstName, String lastName, String email, String city, Date birthDate, Date birthTime, Date birthDateTime, LocalDate localDate, LocalTime localTime, LocalDateTime localDateTime, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
        this.birthDateTime = birthDateTime;
        this.localDate = localDate;
        this.localTime = localTime;
        this.localDateTime = localDateTime;
        this.gender = gender;
    }
}

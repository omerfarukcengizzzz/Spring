package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Display all the employees with email address ''
    List<Employee> findByEmail(String email);

    // Display all employees with firstname '' and lastname '', or show all employees with the '' email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all the employees that firstname is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all the employees where lastname starts with ''
    List<Employee> findByLastNameStartingWith(String lastName);

}

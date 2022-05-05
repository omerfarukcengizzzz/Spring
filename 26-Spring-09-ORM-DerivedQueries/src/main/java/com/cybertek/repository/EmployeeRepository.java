package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    // Display all the employees where the salary is higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all the employees where the salary is less and equal than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display all the employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all the employees that do not have email address
    List<Employee> findByEmailIsNull();

}

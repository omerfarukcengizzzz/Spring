package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    @Query("select e from Employee e")
    List<Employee> getEmployeeList();

    // single bind parameter (positional)
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);

    // multiple bind parameter (positional)
    @Query("select e from Employee e where e.email = ?1 and e.salary = ?2")
    Optional<Employee> getEmployeeByEmailAndSalary(String email, Integer salary);

    // single named parameter
    @Query("select e from Employee e where e.salary = :salary")
    Employee getEmployeeBySalary(@Param("salary") Integer salary);

    // multiple named parameter
    @Query("select e from Employee e where e.firstName = :firstName or e.salary = :salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("firstName") String firstName, @Param("salary") Integer salary);


    // Not equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(Integer salary);

    // Like, Contains, StartsWith, EndsWith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String firstName);

    // Less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(Integer salary);

    // Greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(Integer salary);

    // Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    // Before
    @Query("select e from Employee e where e.hireDate < ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    // null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    // not null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

}

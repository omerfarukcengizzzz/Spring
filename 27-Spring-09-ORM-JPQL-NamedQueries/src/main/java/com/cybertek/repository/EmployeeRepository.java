package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("select e.salary from Employee e where e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    @Query("select e from Employee e")
    List<Employee> getEmployeeList();

}

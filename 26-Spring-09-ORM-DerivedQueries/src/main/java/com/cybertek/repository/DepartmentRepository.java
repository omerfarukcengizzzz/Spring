package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    //Display all the departments in "Furniture" department
    List<Department> findByDepartment(String department);

    // Display all the departments in "Health" division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display all departments with division name ends with 'ics
    List<Department> findByDivisionEndingWith(String suffix);

    // Display top 3 departments with division name including "Hea" without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String division);

}

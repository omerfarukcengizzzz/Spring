package com.cybertek.repository;

import com.cybertek.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentsByDivisionIn(List<String> divisions);

    // Named Query
    List<Department> retrieveDepartmentByDivision(String division);

    // Named query with native query
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String infix);

    List<Department> findDepartment(String division);

    List<Department> countAllDepartments();

}

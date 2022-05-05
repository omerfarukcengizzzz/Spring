package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void testRegions() {

        System.out.println("----- REGIONS START -----");

        System.out.println(regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findByCountryContaining("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByCountryDesc("United"));
        System.out.println(regionRepository.findTop2ByCountry("Canada"));

        System.out.println("----- REGIONS END -----");

    }

    @PostConstruct
    public void testDepartments() {

        System.out.println("----- DEPARTMENTS START -----");

        System.out.println(departmentRepository.findByDepartment("Furniture"));
        System.out.println(departmentRepository.findByDivision("Health"));
        System.out.println(departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));

        System.out.println("----- DEPARTMENTS END -----");

    }

    @PostConstruct
    public void testEmployees() {

        System.out.println("----- EMPLOYEES START -----");

//        System.out.println(employeeRepository.findByEmail("ssymonds2@hhs.gov"));
//        System.out.println(employeeRepository.findByFirstNameAndLastNameOrEmail("Sydney", "Symonds", "btrow5@technorati.com"));
//        System.out.println(employeeRepository.findByFirstNameIsNot("John"));
//        System.out.println(employeeRepository.findByLastNameStartingWith("T"));
//        System.out.println(employeeRepository.findBySalaryGreaterThan(150000));
//        System.out.println(employeeRepository.findBySalaryLessThanEqual(50000));
//        System.out.println(employeeRepository.findByHireDateBetween(LocalDate.of(2010, 6, 1), LocalDate.now()));
//        System.out.println(employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(100000));
//        System.out.println(employeeRepository.findDistinctTop3BySalaryLessThan(100000));
//        System.out.println(employeeRepository.findByEmailIsNull());

        System.out.println("----- EMPLOYEES END -----");

    }

}

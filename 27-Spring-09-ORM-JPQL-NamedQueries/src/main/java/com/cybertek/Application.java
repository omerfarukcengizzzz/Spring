package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @PostConstruct
    public void test() {
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("amcnee1@google.es"));
        System.out.println(employeeRepository.getEmployeeByEmailAndSalary("bmanueau0@dion.ne.jp", 154864));
        System.out.println(employeeRepository.getEmployeeBySalary(154864));

        regionRepository.updateRegionJPQL(3l);
        System.out.println(regionRepository.getRegionByCountry("United States"));

        employeeRepository.updateEmployeeJPQL(1l);
        employeeRepository.updateEmployeeNativeQuery(1);

        System.out.println(departmentRepository.retrieveDepartmentByDivision("Health"));
        System.out.println(departmentRepository.retrieveDepartmentByDivisionContains("om"));

        System.out.println(departmentRepository.findDepartment("Kids"));
        System.out.println(departmentRepository.countAllDepartments());
    }

}

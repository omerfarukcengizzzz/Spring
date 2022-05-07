package com.cybertek;

import com.cybertek.repository.EmployeeRepository;
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

    @PostConstruct
    public void employeeTest() {
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("amcnee1@google.es"));
        System.out.println(employeeRepository.getEmployeeByEmailAndSalary("bmanueau0@dion.ne.jp", 154864));
        System.out.println(employeeRepository.getEmployeeBySalary(154864));
    }

}

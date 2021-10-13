package com.cybertek.controller;

import com.cybertek.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/registration")
    public String registrationForm(Model model) {

        model.addAttribute("employee", new Employee());

        List<String> state = Arrays.asList("Texas", "California", "New York", "Florida", "Washington");
        model.addAttribute("stateList", state);

        return "/employee/register";
    }

    @PostMapping("/list")
    public String showList(@ModelAttribute("employee") Employee employee, Model model) {

        model.addAttribute("employeeList", Arrays.asList(employee));

        String date = employee.getDate().substring(0,4);
        int year = Integer.parseInt(date);

        int age = 2021 - year;

        model.addAttribute("age", age);

        System.out.println(employee.toString());

        return "/employee/list";
    }

}

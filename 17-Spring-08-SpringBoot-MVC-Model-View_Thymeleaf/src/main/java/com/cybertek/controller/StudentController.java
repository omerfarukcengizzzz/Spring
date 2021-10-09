package com.cybertek.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("${name}")
    String name;

    @Value("${year}")
    Integer year;

    @GetMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", name);
        model.addAttribute("year", year);

        return "student/welcome";
    }

}

package com.cybertek.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        // create some random studentID (0-1000) and show it in the UI
        Integer studentID = new Random().nextInt(0, 1000);
        model.addAttribute("studentID", studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        model.addAttribute("numbers", numbers);

        return "student/welcome";
    }

}

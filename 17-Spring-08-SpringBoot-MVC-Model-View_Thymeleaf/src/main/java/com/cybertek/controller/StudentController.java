package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Ozzy");
        /*
            Integer num = 1;
            model.addAttribute(num);
        */
        return "student/welcome";
    }

}

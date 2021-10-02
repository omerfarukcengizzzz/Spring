package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {

    @GetMapping("/show")
    public String showForm() {
        return "home";
    }

}

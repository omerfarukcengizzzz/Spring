package com.cybertek.controller;

import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {

        // creating a Mentor object to bind with the form object
        model.addAttribute("mentor", new Mentor());

        List<String> batch = Arrays.asList("B7", "B8", "B9", "B10", "B11", "EU1", "EU2", "EU3");
        model.addAttribute("batchList", batch);

        return "/mentor/register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor) {

        System.out.println(mentor.toString());

        return "/mentor/register-confirmation";
    }

}

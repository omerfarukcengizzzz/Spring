package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/welcome")
    public String welcome() {
        return "/mentor/welcome";
    }

    @GetMapping("/list")
    public String showTable(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentorList.add(new Mentor("Amy", "Fowler", 33, Gender.FEMALE));
        mentorList.add(new Mentor("Sheldon", "Cooper", 36, Gender.MALE));

        model.addAttribute("mentors", mentorList);

        return "/mentor/list";
    }
}

package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping() {
        return "home";
    }

/*
    @RequestMapping(method = RequestMethod.GET, value = "/cybertek")
    public String getRequestMapping2() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public String postRequestMapping() {
        return "home";
    }
*/

    @GetMapping("/cybertek")
    public String getMapping() {
        return "home";
    }

    @PostMapping("/cybertek")
    public String postMapping() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariable(@PathVariable("name") String name) {
        System.out.println("name = " + name);
        return "home";
    }


}

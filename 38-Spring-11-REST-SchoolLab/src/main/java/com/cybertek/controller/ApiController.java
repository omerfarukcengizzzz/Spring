package com.cybertek.controller;

import com.cybertek.model.Teacher;
import com.cybertek.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/{city}")
    public Object readUserById(@PathVariable("city") String city) {
        String URL = "http://api.weatherstack.com/current?access_key=ed60609d6e1582bafaa71464a763eeb1&query=" + city;

        return restTemplate.getForObject(URL, Object.class);
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }



}

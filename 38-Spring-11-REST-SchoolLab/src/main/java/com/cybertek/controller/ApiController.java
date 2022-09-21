package com.cybertek.controller;

import com.cybertek.enums.ResponseWrapper;
import com.cybertek.model.Teacher;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{city}")
    public Object readUserById(@PathVariable("city") String city) {
        String URL = "http://api.weatherstack.com/current?access_key=ed60609d6e1582bafaa71464a763eeb1&query=" + city;

        return restTemplate.getForObject(URL, Object.class);
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity
                .ok(new ResponseWrapper("Students are successfully retrieved", studentRepository.findAll()));
    }



}

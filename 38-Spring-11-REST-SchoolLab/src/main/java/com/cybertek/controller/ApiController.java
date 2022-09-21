package com.cybertek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public Object readUserById(@PathVariable("id") Integer id) {
        String city = "Henderson";
        String URL = "http://api.weatherstack.com/current?access_key=ed60609d6e1582bafaa71464a763eeb1&query=" + city;

        return restTemplate.getForObject(URL, Object.class, id);
    }

}

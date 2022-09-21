package com.cybertek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("access_key", "ed60609d6e1582bafaa71464a763eeb1");

        String city = "Henderson";

        headers.set("query", city);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("http://api.weatherstack.com/", HttpMethod.GET, entity, Object.class);

        return response;
    }

}

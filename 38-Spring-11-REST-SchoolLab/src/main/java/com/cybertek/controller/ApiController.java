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

    private String URI = "";

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "lTE5abbDxdjGplutvTuc");  // currently, the app-id for the dummyapi.io is not correct

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET, entity, Object.class);

        return response;
    }

}

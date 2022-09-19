package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class HomeController {

    final String URI = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private RestTemplate restTemplate;

    // deserialize
    @GetMapping
    public User[] readAllUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();
    }

    // consumption without deserializing
    @GetMapping(value = "/{id}")
    public Object readUserById(@PathVariable("id") Integer id) {
        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL, Object.class, id);
    }

    // sending headers
    // some APIs will need headers in order to send the required info. exchange() method will help with that
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

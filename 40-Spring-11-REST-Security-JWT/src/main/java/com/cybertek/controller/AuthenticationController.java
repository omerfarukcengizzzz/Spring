package com.cybertek.controller;

import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> login(@RequestBody AuthenticationRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

    }

}

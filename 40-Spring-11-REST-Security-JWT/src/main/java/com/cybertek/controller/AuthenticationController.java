package com.cybertek.controller;

import com.cybertek.annotation.DefaultExceptionMessage;
import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.exception.ServiceException;
import com.cybertek.service.UserService;
import com.cybertek.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    public ResponseEntity<ResponseWrapper> login(@RequestBody AuthenticationRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        User foundUser = userService.readByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(authenticationToken);

        String jwt = jwtUtil.generateToken(foundUser);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/authenticate").toUriString());

        return ResponseEntity
                .created(uri)
                .body(new ResponseWrapper("Authentication token is created successfully!", jwt));
    }


    @PostMapping("/create-user")
    @DefaultExceptionMessage(defaultMessage = "Failed to create the user, please try again!")

    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {

        User newUser = userService.createUser(user);

        return ResponseEntity
                .ok(new ResponseWrapper("User has been created successfully!", newUser));
    }

}

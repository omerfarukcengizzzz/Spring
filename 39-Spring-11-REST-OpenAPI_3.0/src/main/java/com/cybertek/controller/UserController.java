package com.cybertek.controller;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User API")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Get all users from the database")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }


}

package com.cybertek.controller;

import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)  // this annotation is activating authorization in this class
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAll() {
        List<User> userList = userService.getAll();

        return ResponseEntity
                .ok(new ResponseWrapper("User list retrieved successfully!", userList));
    }

}

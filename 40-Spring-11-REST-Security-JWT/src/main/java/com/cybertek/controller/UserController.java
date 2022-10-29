package com.cybertek.controller;

import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.exception.ServiceException;
import com.cybertek.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)  // this annotation is activating authorization in this class
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/read")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ResponseWrapper> readAll() {
        List<User> userList = userService.getAll();

        return ResponseEntity
                .ok(new ResponseWrapper("User list retrieved successfully!", userList));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {

        User newUser = userService.createUser(user);

        return ResponseEntity
                .ok(new ResponseWrapper("User has been created successfully!", newUser));
    }

}

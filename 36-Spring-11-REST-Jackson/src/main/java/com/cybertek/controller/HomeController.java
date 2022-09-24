package com.cybertek.controller;

import com.cybertek.entity.Account;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.service.AccountService;
import com.cybertek.service.CinemaService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    // Dependencies
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private CinemaService cinemaService;

    // Account Controller
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity
                .ok(accountService.getAllAccounts());
    }


    // User Controller
    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return ResponseEntity
                .ok(userService.findByEmail(email));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper> getAllUsers() {
        return ResponseEntity
                .ok(new ResponseWrapper("User list retrieved successfully", userService.retrieveAllUsers()));
    }


    // Cinema Controller
    @GetMapping("/cinemas")
    public ResponseEntity<ResponseWrapper> getAllCinemas() {
        return ResponseEntity
                .ok(new ResponseWrapper("Cinema list has been retrieved successfully", cinemaService.retrieveAll()));
    }

}

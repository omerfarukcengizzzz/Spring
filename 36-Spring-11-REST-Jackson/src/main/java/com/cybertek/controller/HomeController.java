package com.cybertek.controller;

import com.cybertek.entity.Account;
import com.cybertek.entity.User;
import com.cybertek.service.AccountService;
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

    // Account Controller
    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity
                .ok(accountService.getAllAccounts());
    }


    // User Controller
    @GetMapping("/getUser/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return ResponseEntity
                .ok(userService.findByEmail(email));
    }

}

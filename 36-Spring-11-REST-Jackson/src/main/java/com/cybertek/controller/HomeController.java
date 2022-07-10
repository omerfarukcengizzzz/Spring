package com.cybertek.controller;

import com.cybertek.entity.Account;
import com.cybertek.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    // Dependencies
    private AccountRepository accountRepository;

    // Account Controller
    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity
                .ok(accountRepository.getAllAccounts());
    }

}

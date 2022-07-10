package com.cybertek.implementation;

import com.cybertek.entity.Account;
import com.cybertek.repository.AccountRepository;
import com.cybertek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

}

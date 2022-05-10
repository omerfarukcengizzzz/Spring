package com.cybertek;

import com.cybertek.enums.UserRole;
import com.cybertek.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    AccountRepository accountRepository;

    @PostConstruct
    public void test() {

        System.out.println("----------- ACCOUNT REPOSITORY -----------");
        System.out.println(accountRepository.findByCountryOrState("", "Kentucky"));
        System.out.println(accountRepository.findByAgeLessThanEqual(35));
        System.out.println(accountRepository.findByRole(UserRole.ADMIN));
        System.out.println(accountRepository.findByAgeIsBetween(25, 30));
        System.out.println(accountRepository.findByAddressStartingWith("6"));
        System.out.println(accountRepository.getAccountsByOrderByAgeDesc());
        System.out.println(accountRepository.getAllAccounts());
        System.out.println(accountRepository.getAllUserAccounts());
        System.out.println(accountRepository.getAccountsOrderedByAge());
        System.out.println(accountRepository.getAccountsByAgeLessThan(29));
        System.out.println(accountRepository.getAccountsByContaining("osi"));

        System.out.println("----------- CINEMA REPOSITORY -----------");


    }

}

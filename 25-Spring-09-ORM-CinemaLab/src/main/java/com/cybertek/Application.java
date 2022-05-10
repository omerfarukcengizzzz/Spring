package com.cybertek;

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

        System.out.println(accountRepository.findByCountryOrState("United States", ""));

    }

}

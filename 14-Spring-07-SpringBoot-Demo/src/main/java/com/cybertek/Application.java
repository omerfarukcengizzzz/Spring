package com.cybertek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// if you add the scanBasePackages parameter, it will override the default scan package
@SpringBootApplication(scanBasePackages = "com.cybertek")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

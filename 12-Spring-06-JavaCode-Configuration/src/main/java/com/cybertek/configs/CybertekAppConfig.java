package com.cybertek.configs;

import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cybertek")
public class CybertekAppConfig {

    // The reason why we are creating beans in this class is, in some cases we might need to use
    // third party classes and in order to create beans from those classes, we will have to
    // create beans on method level in the Config class
    @Bean
    public Java java() {
        return new Java();
    }

    @Bean
    public Selenium selenium() {
        return new Selenium();
    }

}

package com.cybertek;

import com.cybertek.repository.RegionRepository;
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
    RegionRepository regionRepository;

    @PostConstruct
    public void testRegions() {

        System.out.println("----- REGIONS START -----");

        System.out.println(regionRepository.findByCountry("Canada"));

        System.out.println("----- REGIONS END -----");

    }

}

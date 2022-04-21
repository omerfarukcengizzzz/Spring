package com.cybertek.bootstrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person("Mike", "Smith");
        Person p2 = new Person("Omer", "Cengiz");
        Person p3 = new Person("Tom", "Hanks");

        Address a1 = new Address("King St", "20221");
        Address a2 = new Address("Elm St", "20222");
        Address a3 = new Address("Java St", "20223");

        p1.setAddresses(Arrays.asList(a1, a2));

        personRepository.save(p1);

    }
}

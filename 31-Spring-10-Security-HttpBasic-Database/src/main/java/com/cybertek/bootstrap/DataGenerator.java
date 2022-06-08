package com.cybertek.bootstrap;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Delete all in the beginning
        userRepository.deleteAll();

        // Create users
        User employee = new User("omer", passwordEncoder.encode("omer123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> userList = Arrays.asList(employee, admin, manager);

        userRepository.saveAll(userList);

    }

}

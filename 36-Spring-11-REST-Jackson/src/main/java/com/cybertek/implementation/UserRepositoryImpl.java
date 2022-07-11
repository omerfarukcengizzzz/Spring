package com.cybertek.implementation;

import com.cybertek.entity.User;
import com.cybertek.repository.UserRepository;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserService {

    @Lazy
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return null;
    }
}

package com.cybertek.service;

import com.cybertek.entity.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    List<User> retrieveAllUsers();

}

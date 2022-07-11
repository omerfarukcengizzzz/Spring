package com.cybertek.service;

import com.cybertek.entity.User;

public interface UserService {

    User findByEmail(String email);

}

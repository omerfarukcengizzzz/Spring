package com.cybertek.service;

import com.cybertek.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User foundUser = loadUser(username);

        if (foundUser == null) {
            throw new UsernameNotFoundException("User cannot be found!");
        }

        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(), foundUser.getPassword(), grantedAuthorities(foundUser));
    }

    // custom methods

    public User loadUser(String value) {
        boolean isEmail = value.contains("@");

        return isEmail ? userService.readByEmail(value) : userService.readByUsername(value);
    }

    private List<GrantedAuthority> grantedAuthorities(User user) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole().name()));

        return grantedAuthorityList;
    }
}

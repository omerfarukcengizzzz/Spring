package com.cybertek.security;

import com.cybertek.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    // The reason why we need this class is that spring does not understand the database tables which we created.
    // So, with the help of Spring Security -> UserDetails interface, we just need to implement and override its methods.

    private User user;

    // this constructor is needed in order to create a UserPrincipal(User user) object in UserPrincipalDetailsService class
    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();

        // get the list of permissions
        user.getPermissionList().forEach(p -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p);
            authorityList.add(grantedAuthority);
        });

        // get the list of roles
        user.getRoleList().forEach(r -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(r);  // since the role authority is defined as antMatchers().hasAuthority() we don't need --> "ROLE_"
            authorityList.add(grantedAuthority);
        });

        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive() == 1;
    }
}

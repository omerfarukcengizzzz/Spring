package com.cybertek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()    // request should be authorized
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasAuthority("ADMIN")      // .hasAuthority("ROLE_ADMIN")  -> they are both the same
                .antMatchers("/management/**").hasAnyAuthority("ADMIN", "MANAGER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
                .and()
                .rememberMe()
                .tokenValiditySeconds(120)  // this feature helps the user whether he lost the JSESSION(java session id) from cookies or not,  he will have a unique session id for () seconds.
                .key("cybertekSecret")      // any key
                .userDetailsService(userPrincipalDetailsService);   // we have to define which user are we working with in order to remember
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

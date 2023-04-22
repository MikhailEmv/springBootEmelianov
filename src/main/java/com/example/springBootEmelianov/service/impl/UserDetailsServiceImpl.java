package com.example.springBootEmelianov.service.impl;

import com.example.springBootEmelianov.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder::encode);
        if (username.equals("admin")) {
            return userBuilder.username("admin").password("password").roles("ADMIN").build();
        } else if (username.equals("support")) {
            return userBuilder.username("support").password("password").roles("SUPPORT").build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

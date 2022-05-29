package com.cs590.miniproject.service;

import com.cs590.miniproject.model.Role;
import com.cs590.miniproject.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*var user =  userRepository.findByUsername(username);
        var userDetails = new MyUserDetails(user);
        Set<Role> roles = new HashSet<>();*/
        //return userDetails;
        UserDetails user = User.withUsername(username)
                .password("$2a$10$xmQz8B8jCQpQpU9Ouc8JJOE73dbD5jgw8O7FOZ3gddwBgEb05Kk4q")
                .roles("ADMIN")
                .build();
        //return new User("admin", "$2a$10$xmQz8B8jCQpQpU9Ouc8JJOE73dbD5jgw8O7FOZ3gddwBgEb05Kk4q", new ArrayList<>());
        return user;
    }
}

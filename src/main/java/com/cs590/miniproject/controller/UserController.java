package com.cs590.miniproject.controller;

import com.cs590.miniproject.model.LoginRequest;
import com.cs590.miniproject.model.LoginResponse;
import com.cs590.miniproject.model.User;
import com.cs590.miniproject.service.UserService;
import com.cs590.miniproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User save( @RequestBody User user ){
        return userService.save(user);
    }

}

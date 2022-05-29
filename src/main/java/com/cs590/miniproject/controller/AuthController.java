package com.cs590.miniproject.controller;

import com.cs590.miniproject.model.LoginRequest;
import com.cs590.miniproject.model.LoginResponse;
import com.cs590.miniproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        try{
            System.out.println("Beforeee try catch ");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            System.out.println("Before try catch ");
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username password");
        }
        System.out.println("After try catch ");
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        if(token!=null){
            return ResponseEntity.ok().body(new LoginResponse(token));
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}

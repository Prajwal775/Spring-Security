package com.security.demo.controller;

import com.security.demo.entity.JwtRequest;
import com.security.demo.entity.JwtResponse;
import com.security.demo.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    private Logger logger= LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(),request.getPassword());

        UserDetails userDetails= userDetailsService.loadUserByUsername(request.getEmail());

        String token=this.jwtHelper.generateToken(userDetails);


        JwtResponse response = new JwtResponse.Builder()
                .jwtToken(token)
                .username(userDetails.getUsername())
                .build();



        return new ResponseEntity<>(response, HttpStatus.OK);

    }



    private void doAuthenticate(String email, String password) {


        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
            try

            {
                authenticationManager.authenticate(authToken);
            }
            catch(
            BadCredentialsException e)

            {
                throw new BadCredentialsException("Invalid username or password !!");
            }
        }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "credentials invalid";
    }

    }

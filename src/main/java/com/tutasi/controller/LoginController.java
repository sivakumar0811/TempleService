package com.tutasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tutasi.Model.Users;
import com.tutasi.dto.Token;
import com.tutasi.repository.UsersRepository;
import com.tutasi.service.JwtUserService;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	UsersRepository repo;
	@Autowired
    PasswordEncoder encoder;
	@Autowired
	AuthenticationManager manager;
	@Autowired
	JwtUserService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public Token login(@RequestBody Users request){
        try{
        	Token tokens = new Token();
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String token = jwtService.generateToken(request.getUsername());
            tokens.setTokenId(token);
            return tokens;
        }catch(AuthenticationException e){
        	Token tokens = new Token();
        	tokens.setTokenId("Invalid Credentials");
        	return tokens;
        }
    }
}

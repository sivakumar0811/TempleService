package com.tutasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutasi.Model.Users;
import com.tutasi.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsersRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Users u = repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return User.withUsername(u.getUsername()).password(u.getPassword()).roles("USER").build();
    }
}


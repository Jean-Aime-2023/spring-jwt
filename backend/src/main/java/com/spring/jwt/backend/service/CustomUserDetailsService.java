package com.spring.jwt.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your user loading logic here. This can involve loading user from a database.
        // For example:
        // User user = userRepository.findByUsername(username);
        // if (user == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }
        // return new CustomUserDetails(user);

        throw new UsernameNotFoundException("User not found");
    }
}

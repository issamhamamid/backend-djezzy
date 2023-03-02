package com.example.issamhamamid.demo.jwtsecurity.config;

import com.example.issamhamamid.demo.jwtsecurity.User.User;
import com.example.issamhamamid.demo.jwtsecurity.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.getUserByUsername(username);
       return user.orElseThrow(()-> new UsernameNotFoundException("User not Found " +username));

    }
}

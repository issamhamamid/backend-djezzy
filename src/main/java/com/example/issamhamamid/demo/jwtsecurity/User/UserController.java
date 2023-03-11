package com.example.issamhamamid.demo.jwtsecurity.User;


import com.example.issamhamamid.demo.jwtsecurity.dto.Authrequest;
import com.example.issamhamamid.demo.jwtsecurity.service.JwtService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController


public class UserController {



    private JwtService jwtService;

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;


    public UserController(JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }




    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> showUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/welcome")
    public String Welcome() {
       return "Welcome to the app";
    }


    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User showUsers(@PathVariable int id) {
        User user = userRepository.findById(id).get();


        return user;
    }


    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable int id , @RequestBody User user) {
        User olduser = userRepository.findById(id).get();
        olduser.setUsername(user.getUsername());
        olduser.setLastname(user.getLastname());
        olduser.setFirstname(user.getFirstname());
        olduser.setRoles(user.getRoles());
        olduser.setBirthDate(user.getBirthDate());
        olduser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(olduser);

    }



    @PostMapping("/users/adduser")
    public void addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);

    }



    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);

    }

@PostMapping("/auth")
public String authenticateAndGetToken(@RequestBody Authrequest authrequest) {
    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername()
            , authrequest.getPassword()));
    if(authenticate.isAuthenticated())
    return jwtService.generateToken(authrequest.getUsername());
    else{
        throw new UsernameNotFoundException("invalid user request");
    }

}

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken (@RequestParam String token ){
          String username =  jwtService.extractUsername(token);

         User user = userRepository.getUserByUsername(username).get();


        try {
            Boolean isTokenvalid  = jwtService.validateToken(token , user);
            return ResponseEntity.ok(isTokenvalid);
        } catch (ExpiredJwtException e){
            return ResponseEntity.ok(false);
        }


    }



}

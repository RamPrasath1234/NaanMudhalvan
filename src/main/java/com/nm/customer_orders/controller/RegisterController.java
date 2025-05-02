package com.nm.customer_orders.controller;

import com.nm.customer_orders.enums.Role;
import com.nm.customer_orders.model.RegisterRequest;
import com.nm.customer_orders.model.User;
import com.nm.customer_orders.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;



@RestController
@RequestMapping("/api/auto")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request){
        log.info("register user invoked : {}",request);
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.valueOf(request.getRole().toUpperCase()));

        userRepository.save(user);
        return "user registered successfully";
    }
}

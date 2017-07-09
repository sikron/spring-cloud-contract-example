package com.skronawi.example.springcloudcontract.producer.rest;

import com.skronawi.example.springcloudcontract.producer.persistence.User;
import com.skronawi.example.springcloudcontract.producer.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Collection<User> getIds() {
        return userRepository.findAll();
    }
}

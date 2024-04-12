package com.via.service;

import com.via.entity.Users;
import com.via.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdd {

    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users user) {
        return userRepository.save(user);
    }
}
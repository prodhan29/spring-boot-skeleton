package com.nahid.simpleboot.service;

import com.nahid.simpleboot.security.entity.User;
import com.nahid.simpleboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }
}

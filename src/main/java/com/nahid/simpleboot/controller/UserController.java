package com.nahid.simpleboot.controller;

import com.nahid.simpleboot.dto.UserDTO;
import com.nahid.simpleboot.mapper.UserMapper;
import com.nahid.simpleboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return userMapper.map(userService.getUserById(id));
    }
}

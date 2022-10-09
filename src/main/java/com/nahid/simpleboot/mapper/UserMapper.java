package com.nahid.simpleboot.mapper;

import com.nahid.simpleboot.dto.UserDTO;
import com.nahid.simpleboot.security.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO map(User u) {
        UserDTO dto = new UserDTO();
        dto.setUsername(u.getUsername())
                .setName(u.getName())
                .setId(u.getId());
        return dto;
    }
}

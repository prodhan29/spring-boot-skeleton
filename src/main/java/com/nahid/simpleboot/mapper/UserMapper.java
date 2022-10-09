package com.nahid.simpleboot.mapper;

import com.nahid.simpleboot.dto.UserDTO;
import com.nahid.simpleboot.security.entity.User;
import com.nahid.simpleboot.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO map(User u) {
        UserDTO dto = (UserDTO) ObjectMapperUtil.mapObject(u, new UserDTO());
        return dto;
    }
}

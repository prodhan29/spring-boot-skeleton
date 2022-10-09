package com.nahid.simpleboot.dto;


public class UserDTO {

    public Integer id;

    public String name;

    public String username;

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}

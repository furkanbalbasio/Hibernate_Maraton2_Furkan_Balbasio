package org.example.controller;

import org.example.repository.entity.User;
import org.example.service.UserService;

import java.util.List;
import java.util.Optional;


public class UserController {
    UserService userService;
    public UserController(){
        this.userService = new UserService();
    }


    public Optional<User> loginVerify(String createdUsername){
        return userService.loginVerify(createdUsername);
    }
    public List<User> findAll(){
        return userService.findAll();
    }


}
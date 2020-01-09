package com.store.store.controller;

import com.store.store.Service.UserService;
import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public User loginByPhone(@RequestBody User user){
        return userService.loginByPassword(user);
    }
}

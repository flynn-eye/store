package com.store.store.controller;

import com.store.store.Service.UserService;
import com.store.store.VO.UserList;
import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserMapper userMapper;
    @PostMapping("/login")
    public User loginByPassword(@RequestBody User user){
        return userService.loginByPassword(user);
    }
    @GetMapping("/userList")
    public UserList getUserByPages(@RequestParam(name = "page") Integer page){
        return userService.getUserList(page);
    }
    @PostMapping("/search")
    public UserList searchByUserName(@RequestBody  User user){
        System.out.println(user);
        return userService.searchByUserName(user);
    }
    @PostMapping("/add")
    public Integer addUser(@RequestBody User user){
        System.out.println(user);
        return  userService.addUser(user);
    }
    @PutMapping("/update")
    public Integer updateUser(@RequestBody User user){
        System.out.println(user.getForbidden().getClass());
        return userService.updateUser(user);
    }
    @PostMapping("/findUserById")
    public User findUserById(@RequestBody User user){
        return userService.findUserById(user);
    }
    @PostMapping("/loginByPhone")//获取验证码
    public String loginByPhone(@RequestBody User user) throws Exception {
        return userService.loginByPhone(user);
    }
    @PostMapping("/phoneLogin")//手机登录
    public User phoneLogin(@RequestBody User user) throws Exception {
       String code =  (String) redisTemplate.opsForValue().get(user.getPhone());
       if(code.equals(user.getPassword())){
           return userMapper.loginByPhone(user).get(0);
       }
        return new User() ;
    }
}

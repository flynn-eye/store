package com.store.store.Service;

import com.store.store.VO.UserList;
import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserList userList;
    public User loginByPassword(User user){//账户密码登录
      return   userMapper.loginByPassword(user);
    }
    public void loginByPhone(User user){//手机登录

    }
    public UserList getUserList(Integer pages){
        userList.setList(userMapper.getUserList(pages*10));
        userList.setNum(userMapper.countUsers());
        return userList;
    }
    public  UserList searchByUserName( User user){
        userList.setList(userMapper.searchByUserName(user));
        userList.setNum(userMapper.searchByUserName(user).size());
        return userList;
    }
    public Integer addUser(User user){
        return userMapper.addUser(user);
    }
    public Integer updateUser(User user){
        return  userMapper.updateUser(user);
    }
    public User findUserById(User user){
        return userMapper.findUserById(user);
    }
}

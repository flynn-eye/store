package com.store.store.Service;

import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User loginByPassword(User user){//账户密码登录
      return   userMapper.loginByPassword(user);
    }
    public void loginByPhone(User user){//手机登录

    }
}

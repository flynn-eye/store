package com.store.store.Service;

import com.store.store.VO.UserList;
import com.store.store.entity.User;
import com.store.store.mapper.UserMapper;
import com.store.store.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserList userList;
    @Autowired
    RedisTemplate redisTemplate;
    public User loginByPassword(User user){//账户密码登录
      return   userMapper.loginByPassword(user);
    }
    public String loginByPhone(User user) throws Exception {//手机登录
        MessageUtil messageUtil = new MessageUtil();
        List<User> users =  userMapper.loginByPhone(user);
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        if(users.size()==1){
            User u = users.get(0);
            u.setPassword(vcode);
            redisTemplate.opsForValue().set(u.getPhone(),u.getPassword());
            System.out.println(redisTemplate.opsForValue().get(u.getPhone()));
            messageUtil.sendLoginMsg(u);
            return "短信已发送";
        }
        return "账号不存在";
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

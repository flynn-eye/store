package com.store.store.mapper;

import com.store.store.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;
@Repository
public interface UserMapper {
     User loginByPassword(User users);
     User loginByPhone(User users);
     List<User> getUserList(Integer pages);
     Integer countUsers();
     List<User>  searchByUserName(User user);
     Integer addUser(User user);
     Integer updateUser(User user);
     User findUserById(User user);
}

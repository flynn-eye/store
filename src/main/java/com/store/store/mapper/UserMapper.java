package com.store.store.mapper;

import com.store.store.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;
@Repository
public interface UserMapper {
    public User loginByPassword(User users);
    public User loginByPhone(User users);
}

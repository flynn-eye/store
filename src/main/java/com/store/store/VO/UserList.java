package com.store.store.VO;

import com.store.store.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Component
public class UserList {
    Integer num;
    List<User> list;
}

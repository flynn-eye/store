package com.store.store.mapper;

import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanteenAndWareHouseMapper {
    Integer addCanteenAndWareHouse(WareHouse wareHouse);
    List<WareHouse> getCanteenAndWareHouse();
    List<User> getUserRoleIs4();
    List<WareHouse> userIsInCanteen(User user);
}

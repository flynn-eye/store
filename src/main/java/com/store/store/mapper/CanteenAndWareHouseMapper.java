package com.store.store.mapper;

import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanteenAndWareHouseMapper {
    Integer addCanteenAndWareHouse(WareHouse wareHouse);
    List<WareHouse> getCanteenAndWareHouse();
    List<User> getUserRoleIs4();
    List<WareHouse> userIsInCanteen(User user);
    Integer warehouseUserId(WareHouse wareHouse);
    Integer addWindow(Window window);
    List<Window> getWindowByWareHouseId(WareHouse wareHouse);
    List<User> getUserByRoleIs2();
    List<Window> userIsInWindow(User user);
    Integer updateWindowById(Window window);
    Integer delWindow(Window window);
    Integer delWareHouse(WareHouse wareHouse);
}

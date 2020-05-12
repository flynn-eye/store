package com.store.store.Service;

import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
import com.store.store.mapper.CanteenAndWareHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenAndWareHouseService {
    @Autowired
    CanteenAndWareHouseMapper canteenAndWareHouseMapper;
    public Integer addCanteenAndWareHouse(WareHouse wareHouse){
        return  canteenAndWareHouseMapper.addCanteenAndWareHouse(wareHouse);
    }
    public List<WareHouse> getCanteenAndWareHouse(){
        return canteenAndWareHouseMapper.getCanteenAndWareHouse();
    }
    public  List<User> getUserRoleIs4(){
        return canteenAndWareHouseMapper.getUserRoleIs4();
    }
    public List<WareHouse> userIsInCanteen(User user){
        return canteenAndWareHouseMapper.userIsInCanteen(user);
    }
    public Integer warehouseUserId(WareHouse wareHouse){
        return canteenAndWareHouseMapper.warehouseUserId(wareHouse);
    }
    public  Integer addWindow(Window window){
        return canteenAndWareHouseMapper.addWindow(window);
    }
    public List<Window> getWindowByWareHouseId(WareHouse wareHouse){
        return canteenAndWareHouseMapper.getWindowByWareHouseId(wareHouse);
    }
    public  List<User> getUserByRoleIs2(){
        return canteenAndWareHouseMapper.getUserByRoleIs2();
    }
    public List<Window> userIsInWindow(User user){
        return canteenAndWareHouseMapper.userIsInWindow(user);
    }
    public Integer updateWindowById(Window window){
        return canteenAndWareHouseMapper.updateWindowById(window);
    }
    public Integer delWindow(Window window){
        return canteenAndWareHouseMapper.delWindow(window);
    }
    public Integer delWareHouse(WareHouse wareHouse){
        return canteenAndWareHouseMapper.delWareHouse(wareHouse);
    }
}

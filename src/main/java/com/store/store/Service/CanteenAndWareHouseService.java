package com.store.store.Service;

import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
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
}

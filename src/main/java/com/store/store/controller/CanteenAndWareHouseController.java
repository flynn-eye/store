package com.store.store.controller;

import com.store.store.Service.CanteenAndWareHouseService;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/CanteenAndWareHouse")
public class CanteenAndWareHouseController {
    @Autowired
    CanteenAndWareHouseService canteenAndWareHouseService;
    @PostMapping("/addCanteenAndWareHouse")
    public Integer addCanteenAndWareHouse(@RequestBody WareHouse wareHouse){
        return canteenAndWareHouseService.addCanteenAndWareHouse(wareHouse);
    }
    @GetMapping("/getCanteenAndWareHouse")
    public List<WareHouse> getCanteenAndWareHouse(){
        return canteenAndWareHouseService.getCanteenAndWareHouse();
    }
    @PostMapping("delCanteenAndWareHouse")
    public Integer delCanteenAndWareHouse(@RequestBody WareHouse wareHouse){
        System.out.println(wareHouse);
        return 1;
    }
    @GetMapping("/getUserRoleIs4")
    public List<User> getUserRoleIs4(){
        List<User> userList = canteenAndWareHouseService.getUserRoleIs4();
        List<User> result= new ArrayList<>();
        for (User u:userList
             ) {
            List<WareHouse>wareHouses = canteenAndWareHouseService.userIsInCanteen(u);
            if(wareHouses.size()==0){
                result.add(u);
            }
        }
        return result;
    }
}

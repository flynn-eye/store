package com.store.store.controller;

import com.store.store.Service.CanteenAndWareHouseService;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
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
        List<Window> windows = canteenAndWareHouseService.getWindowByWareHouseId(wareHouse);
        Integer sum=0;
        for (Window w:
             windows) {
            sum+=canteenAndWareHouseService.delWindow(w);

        }
        sum+=canteenAndWareHouseService.delWareHouse(wareHouse);
        System.out.println(wareHouse);
        return sum;
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
    @PostMapping("warehouseUserId")
    public Integer warehouseUserId(@RequestBody WareHouse wareHouse){

        return canteenAndWareHouseService.warehouseUserId(wareHouse);
    }
    @PostMapping("addWindow")
    public  Integer addWindow(@RequestBody Window window){
        System.out.println(window);
        return canteenAndWareHouseService.addWindow(window);
    }
    @PostMapping("getWindowByWareHouseId")
    public List<Window> getWindowByWareHouseId(@RequestBody  WareHouse wareHouse){
        return canteenAndWareHouseService.getWindowByWareHouseId(wareHouse);
    }
    @GetMapping("getUserByRoleIs2")
    public  List<User> getUserByRoleIs2(){
        List<User> userList = canteenAndWareHouseService.getUserByRoleIs2();
        List<User> result = new ArrayList<>();
        for (User u:
        userList  ) {
            List<Window> windows = canteenAndWareHouseService.userIsInWindow(u);
            if(windows.size()==0){
                result.add(u);
            }
        }
        return result;
    }
    @PostMapping("updateWindowById")
    public Integer updateWindowById(@RequestBody Window window){
        return canteenAndWareHouseService.updateWindowById(window);
    }
    @PostMapping("delWindow")
    public Integer delWindow(@RequestBody Window window){
        return canteenAndWareHouseService.delWindow(window);
    }

}

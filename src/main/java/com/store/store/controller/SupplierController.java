package com.store.store.controller;

import com.store.store.Service.SupplierService;
import com.store.store.Service.UserService;
import com.store.store.VO.SupplierShow;
import com.store.store.VO.UserList;
import com.store.store.entity.FoodClass;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @Autowired
    UserService userService;
    @GetMapping("/search")
    public Supplier searchSupplierByName(@RequestParam(name = "name") String name){
        return new Supplier();
    }
    @PostMapping("/isSupplierIn")
    public Integer isSupplierIn(@RequestBody User user){
        return  supplierService.isSupplierIn(user).size();
    }
    @PostMapping("/addSupplier")
    public Integer addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @PostMapping("/getSupplier")
    public List<SupplierShow> getSupplier(){
        List<Supplier> suppliers = supplierService.getSupplier();
        List<SupplierShow> supplierShows = new ArrayList<>();
        for (Supplier s:suppliers
             ) {
            SupplierShow supplierShow = new SupplierShow();
            User user = new User();
            FoodClass foodClass = new FoodClass();
            user.setUserId(String.valueOf(s.getUserId()));
            User u = userService.findUserById(user);
            supplierShow.setUserName(u.getUserName());
            supplierShow.setUserId(s.getUserId());
            supplierShow.setAddress(s.getAddress());
            supplierShow.setPhone(u.getPhone());
            supplierShow.setSupplierId(s.getSupplierId());
            supplierShow.setUserName(s.getSupplierName());
            supplierShow.setSupplierRate(s.getSupplierRate());
            supplierShow.setPic(s.getPic());
            foodClass.setClassId(Integer.valueOf(s.getSupplierClass()));
            List<FoodClass>foodClasses = supplierService.getFoodClassById(foodClass);
            supplierShow.setClassName(foodClasses.get(0).getClassName());
            supplierShow.setSupplierClass(s.getSupplierClass());
            supplierShow.setSupplierName(s.getSupplierName());
            supplierShows.add(supplierShow);
        }
        return supplierShows;
    }
}

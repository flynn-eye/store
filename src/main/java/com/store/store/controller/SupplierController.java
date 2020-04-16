package com.store.store.controller;

import com.store.store.Service.SupplierService;
import com.store.store.VO.UserList;
import com.store.store.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @GetMapping("/search")
    public Supplier searchSupplierByName(@RequestParam(name = "name") String name){
        return new Supplier();
    }
}

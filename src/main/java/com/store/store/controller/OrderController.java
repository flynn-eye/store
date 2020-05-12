package com.store.store.controller;

import com.store.store.Service.OrderService;
import com.store.store.VO.AddBidding;
import com.store.store.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/getSupplierFoodClassId")
    public Supplier getSupplierFoodClassId(@RequestBody Supplier supplier){
        return orderService.getSupplierFoodClassId(supplier).get(0);
    }
    @PostMapping("/getTodayBidding")
    public Order getTodayBidding(@RequestBody Order order){
        return orderService.getTodayBidding(order).get(0);
    }
    @PostMapping("/getItemByItemId")
    public Item getItemByItemId(@RequestBody Item item){
        return orderService.getItemByItemId(item).get(0);
    }
    @PostMapping("/getWareHouseById")
    public List<WareHouse> getWareHouseById(@RequestBody WareHouse wareHouse){
        return orderService.getWareHouseById(wareHouse);
    }
    @PostMapping("/getSupplierByUser")
    public  List<Supplier> getSupplierByUser(@RequestBody User user){
        return orderService.getSupplierByUser(user);
    }
    @PostMapping("/getWaitInputOrder")
    public List<Order> getWaitInputOrder(@RequestBody Order order){
        return orderService.getWaitInputOrder(order);
    }
    @PostMapping("/getAddBiddingBySupplierAndOrder")
    public List<AddBidding> getAddBiddingBySupplierAndOrder(@RequestBody Bidding bidding){
        return orderService.getAddBiddingBySupplierAndOrder(bidding);
    }
    @PostMapping("/inBidding")
    public List<AddBidding> inBidding(@RequestBody Bidding bidding){
        return orderService.inBidding(bidding);
    }
}



package com.store.store.controller;

import com.store.store.Service.BiddingService;
import com.store.store.VO.AddBidding;
import com.store.store.entity.Order;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
    @Autowired
    BiddingService biddingService;
    @PostMapping("/addBidding")
    public Integer addBidding(@RequestBody AddBidding addBidding){
        System.out.println(addBidding);
        return biddingService.addBidding(addBidding);
    }
    @PostMapping("/getOrder")
    public List<Order> getOrder(){
        return biddingService.getOrder();
    }
    @PostMapping("/getSupplierById")
    public Supplier getSupplierById(@RequestBody Supplier supplier){
        return biddingService.getSupplierById(supplier).get(0);
    }
    @PostMapping("/getWareHouseByUserId")
    public WareHouse getWareHouseByUserId(@RequestBody User user){
        return biddingService.getWareHouseByUserId(user).get(0);
    }
}

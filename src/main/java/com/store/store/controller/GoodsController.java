package com.store.store.controller;

import com.store.store.Service.GoodsService;
import com.store.store.VO.GoodsVo;
import com.store.store.VO.OrderVo;
import com.store.store.entity.Goods;
import com.store.store.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @PostMapping("/insertGoods")
    public Integer insertGoods(@RequestBody Goods goods){
        return goodsService.insertGoods(goods);
    }
    @PostMapping("/endInput")
    public Integer endInput(@RequestBody Order order){
        return goodsService.endInput(order);
    }
    @PostMapping("/getGoods")
    public List<GoodsVo> getGoods(){
        return goodsService.getGoods();
    }
    @PostMapping("/getOrders")
    public List<OrderVo> getOrders(){
        return goodsService.getOrders();
    }
}

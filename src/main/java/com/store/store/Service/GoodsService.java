package com.store.store.Service;

import com.store.store.VO.GoodsVo;
import com.store.store.VO.OrderVo;
import com.store.store.entity.Goods;
import com.store.store.entity.Order;
import com.store.store.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public Integer insertGoods(Goods goods){
        return goodsMapper.insertGoods(goods);
    }
    public Integer endInput(Order order){
        return goodsMapper.endInput(order);
    }
    public List<GoodsVo> getGoods(){
        return goodsMapper.getGoods();
    }
    public List<OrderVo> getOrders(){
        return goodsMapper.getOrders();
    }
}

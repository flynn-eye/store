package com.store.store.mapper;

import com.store.store.VO.GoodsVo;
import com.store.store.VO.OrderVo;
import com.store.store.entity.Goods;
import com.store.store.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    Integer insertGoods(Goods goods);
    Integer endInput(Order order);
    List<GoodsVo> getGoods();
    List<OrderVo> getOrders();
}

package com.store.store.mapper;

import com.store.store.VO.AddBidding;
import com.store.store.entity.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    Integer addOrder(Order order);
    List<Window> findWindowByUserId(Require require);
    List<Item> getItemByItemId(Item item);
    List<FoodClass> getFoodClassByItem(Item item);
    List<Supplier> getSupplierFoodClassId(Supplier supplier);
    List<Order> getTodayBidding(Order order);
    List<WareHouse> getWareHouseById(WareHouse wareHouse);
    Integer addBidding(AddBidding addBidding);
    List<Order> getWaitInputOrder(Order order);//待发货竞标
    List<Order> findOrderInBidding();
    List<Supplier> getSupplierByUser(User user);
    List<AddBidding> getAddBiddingBySupplierAndOrder(Bidding bidding);
    List<AddBidding> inBidding(Bidding bidding);//正在竞标
}

package com.store.store.mapper;

import com.store.store.VO.AddBidding;
import com.store.store.VO.BiddingResult;
import com.store.store.entity.Order;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingMapper {
    List<AddBidding> getBidding(String time);
    Integer biddingSuccess(BiddingResult biddingResult);
    List<Order> getOrder(String time);
    List<Supplier> getSupplierById(Supplier supplier);
    List<WareHouse> getWareHouseByUserId(User user);
}

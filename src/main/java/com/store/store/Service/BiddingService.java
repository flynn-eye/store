package com.store.store.Service;

import com.alibaba.fastjson.JSON;
import com.store.store.VO.AddBidding;
import com.store.store.VO.BiddingResult;
import com.store.store.VO.FoodBidding;
import com.store.store.entity.Order;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.mapper.BiddingMapper;
import com.store.store.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BiddingService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    BiddingMapper biddingMapper;
    public Integer addBidding(AddBidding addBidding){
        addBidding.setDetail(JSON.toJSONString(addBidding.getFoods()));
        return orderMapper.addBidding(addBidding);
    }
    public Integer getBidding(){
        Calendar calendar=Calendar.getInstance();
        String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String d = String.valueOf(calendar.get(Calendar.DATE));
        String y = String.valueOf(calendar.get(Calendar.YEAR));
        List<AddBidding> addBiddings= biddingMapper.getBidding(y+'-'+m+'-'+d);
        Map<Integer, BiddingResult> result = new HashMap<>();
        for (AddBidding a:addBiddings
             ) {
            List<FoodBidding> foodBiddings=JSON.parseArray(a.getDetail(),FoodBidding.class);
            Double price = 0.0;
            BiddingResult biddingResult = new BiddingResult();
            if(result.containsKey(a.getOrderId())){
                 biddingResult = result.get(a.getOrderId());
            }
            for (FoodBidding f:foodBiddings
            ) {
                price+=f.getPrice()*f.getCount();
            }
            biddingResult.setPrice(price);
            biddingResult.setSupplierId(Integer.valueOf(a.getSupplierId()));
            result.put(a.getOrderId(),biddingResult);
        }
        Integer sum = 0;
        for (Integer key:
             result.keySet()) {
            BiddingResult r = result.get(key);
            r.setOrderId(key);
            sum+=biddingMapper.biddingSuccess(r);
        }
        return sum;
    }
    public List<Order> getOrder(){
        Calendar calendar=Calendar.getInstance();
        String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String d = String.valueOf(calendar.get(Calendar.DATE)-1);
        String y = String.valueOf(calendar.get(Calendar.YEAR));
        return biddingMapper.getOrder(y+'-'+m+'-'+d);
    }
    public List<Supplier> getSupplierById(Supplier supplier){
        return biddingMapper.getSupplierById(supplier);
    }
    public List<WareHouse> getWareHouseByUserId(User user){
        return biddingMapper.getWareHouseByUserId(user);
    }
}

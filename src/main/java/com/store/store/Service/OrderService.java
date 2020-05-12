package com.store.store.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.store.store.VO.AddBidding;
import com.store.store.VO.ItemInf;
import com.store.store.entity.*;
import com.store.store.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    RequireService requireService;
    @Autowired
    OrderMapper orderMapper;
    public Integer addOrder(){
        Map<Integer,Integer> map = new HashMap<>();//总订单
        List<Require> requires = requireService.adminGetRequire();
        if(requires.size()>0){
            for (Require r: requires
                 ) {
                String s = r.getItemInf();
                List<ItemInf> itemInf = JSON.parseArray(s, ItemInf.class);
                for (ItemInf i:
                     itemInf) {
                    if(map.containsKey(i.getItemId())){
                        map.put(i.getItemId(),(map.get(i.getItemId())+i.getCount()));
                    }else{
                        map.put(i.getItemId(),i.getCount());
                    }
                }
            }
        }
        Map<Integer,Map<Integer,Integer>> sendMap = new HashMap<>();//发货订单
        if(requires.size()>0){
            for (Require r: requires
            ) {
                List<Window> windows = orderMapper.findWindowByUserId(r);

                if(sendMap.containsKey(windows.get(0).getWareHouseId())){
                    Map<Integer,Integer> m1 = sendMap.get(windows.get(0).getWareHouseId());
                    String s = r.getItemInf();
                    List<ItemInf> itemInf = JSON.parseArray(s, ItemInf.class);
                    for (ItemInf i:
                            itemInf) {
                        if(m1.containsKey(i.getItemId())){
                            m1.put(i.getItemId(),(m1.get(i.getItemId())+i.getCount()));
                        }else{
                            m1.put(i.getItemId(),i.getCount());
                        }
                    }
                    sendMap.put(windows.get(0).getWareHouseId(),m1);
                }else {
                    Map<Integer,Integer> m1 = new HashMap<>();
                    String s = r.getItemInf();
                    List<ItemInf> itemInf = JSON.parseArray(s, ItemInf.class);
                    for (ItemInf i:
                            itemInf) {
                        if(m1.containsKey(i.getItemId())){
                            m1.put(i.getItemId(),(m1.get(i.getItemId())+i.getCount()));
                        }else{
                            m1.put(i.getItemId(),i.getCount());
                        }
                    }
                    sendMap.put(windows.get(0).getWareHouseId(),m1);
                }
            }
        }
        Map<Integer,Map<Integer,Integer>> orderMaps = new HashMap<>();//foodclass 第一个key是foodclassId
        Map<Integer,Map<Integer,Map<Integer,Integer>>> sendMapOrder = new HashMap<>();
        //第一个integer是食堂id 第二个foodclass 第三个
        for (Integer k: map.keySet()
             ) {
            Integer count = map.get(k);
            Item i = new Item();
            i.setItemId(k);
            Item item = orderMapper.getItemByItemId(i).get(0);
            FoodClass foodClass = orderMapper.getFoodClassByItem(item).get(0);
            Integer parentId = foodClass.getParentId();
            if(orderMaps.containsKey(parentId)){
                Map<Integer,Integer> m1 = orderMaps.get(parentId);
                if(m1.containsKey(k)){
                    m1.put(k,count+m1.get(k));
                }else{
                    m1.put(k,count);
                }
                orderMaps.put(parentId,m1);
            }else{
               Map<Integer,Integer> m1 = new HashMap<>();
               m1.put(k,count);
               orderMaps.put(parentId,m1);
            }
        }
        for (Integer key:sendMap.keySet()//key地址
             ) {
            Map<Integer,Integer>m1 = sendMap.get(key);
            for (Integer k:m1.keySet()//k is itemid
                 ) {
                Item i = new Item();
                i.setItemId(k);
                Item item = orderMapper.getItemByItemId(i).get(0);
                FoodClass foodClass = orderMapper.getFoodClassByItem(item).get(0);

                if(sendMapOrder.containsKey(foodClass.getParentId())){
                    Map<Integer,Map<Integer,Integer>> m2 = sendMapOrder.get(foodClass.getParentId());
                    if(m2.containsKey(key)){
                        Map<Integer,Integer> m3 = m2.get(key);
                        if(m3.containsKey(k)){
                            m3.put(k,m1.get(k)+m3.get(k));
                        }else {
                            m3.put(k,m1.get(k));
                        }
                        m2.put(key,m3);
                    }else{
                        Map<Integer,Integer> m3 = new HashMap<>();
                        m3.put(k,m1.get(k));
                        m2.put(key,m3);
                    }
                    sendMapOrder.put(foodClass.getParentId(),m2);
                }else{
                    Map<Integer,Map<Integer,Integer>> m2 = new HashMap<>();
                    Map<Integer,Integer> m3 = new HashMap<>();//kv itemId count
                    m3.put(k,m1.get(k));
                    m2.put(key,m3);
                    sendMapOrder.put(foodClass.getParentId(),m2);
                }
            }

        }
        for (Integer key:orderMaps.keySet()
             ) {
            Order order = new Order();
            Calendar calendar=Calendar.getInstance();
            String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
            String d = String.valueOf(calendar.get(Calendar.DATE));
            String y = String.valueOf(calendar.get(Calendar.YEAR));
            order.setTime(y+'-'+m+'-'+d);
            String mapString= JSON.toJSONString(orderMaps.get(key));
            String sendMapString = JSON.toJSONString(sendMapOrder.get(key));
            order.setDetail(mapString);
            order.setSendInf(sendMapString);
            order.setClassId(key);
            orderMapper.addOrder(order);
        }
        return 1;
    }
    public List<Supplier> getSupplierFoodClassId(Supplier supplier){
        return orderMapper.getSupplierFoodClassId(supplier);
    }
    public List<Order> getTodayBidding(Order order){
        Calendar calendar=Calendar.getInstance();
        String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String d = String.valueOf(calendar.get(Calendar.DATE));
        String y = String.valueOf(calendar.get(Calendar.YEAR));
        order.setTime(y+'-'+m+'-'+d);
        return orderMapper.getTodayBidding(order);
    }
    public List<Item> getItemByItemId(Item item){
        return orderMapper.getItemByItemId(item);
    }
    public List<WareHouse> getWareHouseById(WareHouse wareHouse){
        return orderMapper.getWareHouseById(wareHouse);
    }
    public  List<Supplier> getSupplierByUser(User user){
        return orderMapper.getSupplierByUser(user);
    }
    public List<Order> getWaitInputOrder(Order order){
        return orderMapper.getWaitInputOrder(order);
    }
    public List<AddBidding> getAddBiddingBySupplierAndOrder(Bidding bidding){
        return orderMapper.getAddBiddingBySupplierAndOrder(bidding);
    }
    public List<AddBidding> inBidding(Bidding bidding){
        List<Order> orders = orderMapper.findOrderInBidding();
        List<AddBidding> biddings = new ArrayList<>();
        for (Order o:orders
             ) {
            bidding.setOrderId(o.getOrderId());
            List<AddBidding> bs = orderMapper.inBidding(bidding);
            for (AddBidding b:bs
                 ) {
                biddings.add(b);
            }
        }
        return biddings;
    }
}

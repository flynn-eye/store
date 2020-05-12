package com.store.store.util;

import com.store.store.Service.BiddingService;
import com.store.store.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Component
public class RequireTask {
    @Autowired
    OrderService orderService;
    @Autowired
    BiddingService biddingService;
    @Scheduled(cron = "0 0,17 0,18 * * ? ")//设置时间
    public void requireToOrder(){
        orderService.addOrder();
    }
    @Scheduled(cron = "0 0,49 0,22 * * ? ")//设置时间
    public void cheapestBidding(){
        int res = biddingService.getBidding();
        System.out.println(res);
    }
}

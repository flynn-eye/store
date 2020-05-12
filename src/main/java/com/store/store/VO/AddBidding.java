package com.store.store.VO;

import lombok.Data;

import java.util.List;

@Data
public class AddBidding {
    public Integer biddingId;
    public String supplierId;
    public String time;
    public Integer orderId;
    public List<FoodBidding> foods;
    public String detail;

}

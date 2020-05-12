package com.store.store.entity;

import lombok.Data;

@Data
public class Bidding {
    Integer biddingId;
    Integer supplierId;
    String detail;
    Integer orderId;
    String time;
}

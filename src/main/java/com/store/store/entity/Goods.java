package com.store.store.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Goods {
    Integer goodsId;
    Integer itemId;
    Integer wareHouseId;
    Integer classId;
    Integer supplierId;
    Timestamp inTime;
    Integer orderId;
    Integer requireId;
    Integer windowId;
    Integer weight;
}

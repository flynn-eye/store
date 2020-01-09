package com.store.store.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    Integer orderId;
    Timestamp time;
    Integer requireId;
    Integer supplierId;
    Integer price;
    String detail;
    Integer status;
}

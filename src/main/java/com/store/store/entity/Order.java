package com.store.store.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    Integer orderId;
    String time;
    Integer requireId;
    Integer supplierId;
    Integer price;
    String detail;
    Integer status;
    Integer classId;
    String sendInf;
    Integer rate;
}

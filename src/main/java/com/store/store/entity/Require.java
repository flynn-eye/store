package com.store.store.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Require {
    Integer requireId;
    String createTime;
    String itemInf;
    String userId;
    Integer status;
    String rejectReason;
    String isReceive;
}

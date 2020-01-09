package com.store.store.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Require {
    Integer requireId;
    Timestamp createTime;
    String itemInf;
    Integer windowsId;
    Integer status;
    String rejectReason;
}

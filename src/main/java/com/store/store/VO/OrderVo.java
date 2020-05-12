package com.store.store.VO;

import lombok.Data;

@Data
public class OrderVo {
    Integer orderId;
    Integer biddingId;
    String time;
    Integer supplierId;
    Double price;
    Integer status;
    String detail;
    String supplierName;
    String className;
}

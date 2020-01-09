package com.store.store.entity;

import lombok.Data;

@Data
public class Supplier {
    Integer supplierId;
    String supplierName;
    Integer userId;
    String pic;
    String address;
    String supplierClass;
    Integer supplierRate;
}

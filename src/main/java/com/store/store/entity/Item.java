package com.store.store.entity;

import lombok.Data;

@Data
public class Item {
    Integer itemId;
    String itemName;
    Integer itemQgp;
    Integer lastPrice;
    String priceCharts;
    Integer classId;
    Integer uintId;

}

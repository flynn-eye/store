package com.store.store.VO;

import lombok.Data;



@Data
public class ItemInf {
    Integer count;
    String itemName;
    Integer itemId;//详细商品
    Integer classId;//第二大类
}

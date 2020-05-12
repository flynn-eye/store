package com.store.store.VO;

import com.store.store.entity.Goods;
import com.store.store.entity.Item;
import com.store.store.entity.Supplier;
import com.store.store.entity.WareHouse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Data
public class GoodsVo {
    Integer goodsId;
    Integer itemId;
    Integer wareHouseId;
    Integer supplierId;
    String inTime;
    Integer orderId;
    Integer weight;
    String supplierName;
    String itemName;
    Integer itemQgp;
    String unitId;
    String name;
}

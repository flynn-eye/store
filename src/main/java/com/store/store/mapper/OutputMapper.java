package com.store.store.mapper;

import com.store.store.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutputMapper {
    List<WareHouse>getWareHouseByUserId(User user);
    List<Require> getRequireIs2ByUserId(Window window);
    Integer output(Require require);
    List<Require> findRequire(Require require);
    Integer isReceive(Require require);
    Integer endOutput(Require require);
    List<Goods> findGoods(Goods goods);
    Integer changeGoods(Goods goods);
    Integer delGoods(Goods goods);
}

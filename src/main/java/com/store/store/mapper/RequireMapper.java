package com.store.store.mapper;

import com.store.store.VO.RequireUser;
import com.store.store.entity.Require;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequireMapper {
    Integer addRequire(Require require);
    List<Require> adminGetRequire(String createTime);
    List<Window> findWindowByUserId(User user);
    List<WareHouse> findWareHouseByWareHouseId(Window window);
    Integer updateRequire(Require require);
    List<Require> getUnOutputRequire(RequireUser requireUser);
    List<Require> getUnOutputResolve(RequireUser requireUser);
    Integer updateItemInf(Require require);
}

package com.store.store.Service;

import com.store.store.VO.RequireUser;
import com.store.store.entity.Require;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
import com.store.store.mapper.RequireMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RequireService {
    @Autowired
    RequireMapper requireMapper;
    public Integer addRequire(Require require){
        return requireMapper.addRequire(require);
    }
    public List<Require> adminGetRequire(){
        Calendar calendar=Calendar.getInstance();
        String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String d = String.valueOf(calendar.get(Calendar.DATE));
        String y = String.valueOf(calendar.get(Calendar.YEAR));
        return requireMapper.adminGetRequire(y+'-'+m+'-'+d);
    }
    public List<Window> findWindowByUserId(User user){
        return requireMapper.findWindowByUserId(user);
    }
    public  List<WareHouse> findWareHouseByWareHouseId(Window window){
        return requireMapper.findWareHouseByWareHouseId(window);
    }
    public Integer updateRequire(Require require){
        return requireMapper.updateRequire(require);
    }
    public List<Require> getUnOutputRequire(RequireUser requireUser){
        return requireMapper.getUnOutputRequire(requireUser);
    }
    public List<Require> getUnOutputResolve(RequireUser requireUser){
        Calendar calendar=Calendar.getInstance();
        String m = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String d = String.valueOf(calendar.get(Calendar.DATE));
        String y = String.valueOf(calendar.get(Calendar.YEAR));
        requireUser.setTime(y+'-'+m+'-'+d);
        return requireMapper.getUnOutputResolve(requireUser);
    }
    public Integer updateItemInf(Require require){
        return requireMapper.updateItemInf(require);
    }
}

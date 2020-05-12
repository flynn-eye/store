package com.store.store.Service;

import com.store.store.entity.*;
import com.store.store.mapper.CanteenAndWareHouseMapper;
import com.store.store.mapper.OutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputService {
    @Autowired
    OutputMapper outputMapper;
    @Autowired
    CanteenAndWareHouseMapper canteenAndWareHouseMapper;
    public List<Window> getWindow(User user){
        List<WareHouse> wareHouses = outputMapper.getWareHouseByUserId(user);
        WareHouse wareHouse = wareHouses.get(0);
        return canteenAndWareHouseMapper.getWindowByWareHouseId(wareHouse);
    }
    public  List<Require> getRequireIs2ByUserId(Window window){
        return outputMapper.getRequireIs2ByUserId(window);
    }
    public Integer output(Require require){
        Integer size = outputMapper.findRequire(require).size();
        if(size==0){
            Integer sum = 0;
            sum+=outputMapper.isReceive(require);
            sum+=outputMapper.output(require);
            return sum;
        }
        return outputMapper.output(require);
    }
    public Integer endOutput(Require require){
        return outputMapper.endOutput(require);
    }
    public Integer updateGoods(Goods goods){/*待测试*/
        Goods resultGoods = outputMapper.findGoods(goods).get(0);
        System.out.println(resultGoods);
        Integer sum = 0;
        while(goods.getWeight()!=0){
            if(goods.getWeight()==resultGoods.getWeight()){
                sum+=outputMapper.delGoods(resultGoods);
                goods.setWeight(0);
            }else if(goods.getWeight()<resultGoods.getWeight()){
                resultGoods.setWeight(resultGoods.getWeight()-goods.getWeight());
                sum+=outputMapper.changeGoods(resultGoods);
                goods.setWeight(0);
            }else{
                goods.setWeight(goods.getWeight()-resultGoods.getWeight());
                sum+=outputMapper.delGoods(resultGoods);
                resultGoods = outputMapper.findGoods(goods).get(0);
            }
        }
        return sum;
    }
}

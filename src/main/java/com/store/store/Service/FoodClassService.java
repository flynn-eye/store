package com.store.store.Service;

import com.store.store.entity.FoodClass;
import com.store.store.entity.Item;
import com.store.store.mapper.FoodClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodClassService {
    @Autowired
    FoodClassMapper foodClassMapper;
    public Integer addParentClass(String className){
        return foodClassMapper.addParentClass(className);
    }
    public List<FoodClass> getParentClass(){
        return foodClassMapper.getParentClass();
    }
    public FoodClass getClassIdByName(FoodClass foodClass){
        return  foodClassMapper.getClassIdByName(foodClass);
    }
    public Integer  addChildClass(FoodClass foodClass){
        return foodClassMapper.addChildClass(foodClass);
    }
    public List<FoodClass> getChildClass(FoodClass foodClass){
        return foodClassMapper.getChildClass(foodClass);
    }
    public Integer addItem(Item item){
        return foodClassMapper.addItem(item);
    }
    public List<Item> getItem(FoodClass foodClass){
        return foodClassMapper.getItem(foodClass);
    }
    public Integer delClass(FoodClass foodClass){//删除foodclassbyclassId
        return  foodClassMapper.delClass(foodClass);
    }
    public Integer delClassByParentId(FoodClass foodClass){
        return foodClassMapper.delClassByParentId(foodClass);//删除foodclassbyparentId
    }
    public Integer delItemByParentId(FoodClass foodClass){//删除itembyparentId
        return foodClassMapper.delItemByParentId(foodClass);
    }
    public Integer delItemByItemId(Item item){
        return foodClassMapper.delItemByItemId(item);
    }
    public Integer updateItem(Item item){
        return foodClassMapper.updateItem(item);
    }
}

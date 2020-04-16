package com.store.store.mapper;

import com.store.store.entity.FoodClass;
import com.store.store.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodClassMapper {
    Integer addParentClass(String className);
    List<FoodClass> getParentClass();
    FoodClass getClassIdByName(FoodClass foodClass);
    Integer addChildClass(FoodClass foodClass);
    List<FoodClass> getChildClass(FoodClass foodClass);
    Integer addItem(Item item);
    List<Item> getItem(FoodClass foodClass);
    Integer delClass(FoodClass foodClass);
    Integer delClassByParentId(FoodClass foodClass);
    Integer delItemByParentId(FoodClass foodClass);
    Integer delItemByItemId(Item item);
    Integer updateItem(Item item);
}

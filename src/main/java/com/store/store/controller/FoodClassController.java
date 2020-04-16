package com.store.store.controller;

import com.store.store.Service.FoodClassService;
import com.store.store.VO.FoodClassList;
import com.store.store.entity.FoodClass;
import com.store.store.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodClass")
public class FoodClassController {
    @Autowired
    FoodClassService foodClassService;
    @Autowired
    FoodClassList foodClassList;
    @PostMapping("addParent")
    public Integer addParentClass(@RequestBody FoodClass foodClass){
        return foodClassService.addParentClass(foodClass.getClassName());
    }
    @GetMapping("getParentClass")
    public FoodClassList getParentClass(){
        try{
            foodClassList.setFoodClasses(foodClassService.getParentClass());
            foodClassList.setResult(1);
        }catch (Exception e){
            foodClassList.setResult(0);
        }
        return foodClassList ;
    }
    @PostMapping("addChildClass")
    public Integer addChildClass(@RequestBody FoodClass foodClass){
        Integer  parentId = foodClassService.getClassIdByName(foodClass).getClassId();
        foodClass.setParentId(parentId);
        return  foodClassService.addChildClass(foodClass);
    }
    @GetMapping("getChildClass")
    public FoodClassList getChildClass(@RequestParam Integer classId){
        FoodClass foodClass = new FoodClass();
        foodClass.setParentId(classId);
        foodClassList.setFoodClasses(foodClassService.getChildClass(foodClass));
        return foodClassList;
    }
    @PostMapping("addItem")
    public Integer addItem(@RequestBody Item item){
        FoodClass foodClass = new FoodClass();
        foodClass.setParentName(item.getChildName());
        System.out.println(foodClass);
        Integer  parentId = foodClassService.getClassIdByName(foodClass).getClassId();
        item.setClassId(parentId);
        foodClassService.addItem(item);
        return 1;
    }
    @GetMapping("getItem")
    public List<Item> getItem(@RequestParam Integer classId){
        FoodClass foodClass = new FoodClass();
        foodClass.setClassId(classId);
        return foodClassService.getItem(foodClass);
    }
    @PostMapping("foodClass")
    public Integer delClass(@RequestBody FoodClass foodClass){
        if(foodClass.getParentId()==null){//第一大类删三处
            foodClass.setParentId(foodClass.getClassId());
            List<FoodClass>foodClassList = foodClassService.getChildClass(foodClass);//第二大类列表
            Integer sum = 0;
            for (FoodClass f:foodClassList
                 ) {
                Integer num1= foodClassService.delItemByParentId(f);
                Integer num2 = foodClassService.delClass(f);
                sum +=num1+num2;
            }
            return sum+=foodClassService.delClass(foodClass);
        }else{//第二大类删两处
            Integer num1= foodClassService.delItemByParentId(foodClass);
            Integer num2 = foodClassService.delClass(foodClass);
            return  num1+num2;
        }
    }
    @PostMapping("item")
    public Integer delItem(@RequestBody Item item){
        System.out.println(item);
        return foodClassService.delItemByItemId(item);
    }
    @PostMapping("updateItem")
    public Integer updateItem(@RequestBody Item item){
        System.out.println(item);
        return  foodClassService.updateItem(item);
    }
}

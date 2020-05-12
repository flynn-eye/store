package com.store.store.Service;

import com.store.store.VO.SupplierShow;
import com.store.store.entity.FoodClass;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import com.store.store.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    public List<Supplier> isSupplierIn(User user){
        return supplierMapper.isSupplierIn(user);
    }
    public Integer addSupplier(Supplier supplier){
        return supplierMapper.addSupplier(supplier);
    }
    public List<Supplier> getSupplier(){
        return supplierMapper.getSupplier();
    }
    public List<FoodClass> getFoodClassById(FoodClass foodClass){
        return supplierMapper.getFoodClassById(foodClass);
    }
}

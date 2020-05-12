package com.store.store.mapper;

import com.store.store.VO.SupplierShow;
import com.store.store.entity.FoodClass;
import com.store.store.entity.Supplier;
import com.store.store.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierMapper {
    List<Supplier> isSupplierIn(User user);
    Integer addSupplier(Supplier supplier);
    List<Supplier> getSupplier();
    List<FoodClass> getFoodClassById(FoodClass foodClass);
}

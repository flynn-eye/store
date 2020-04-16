package com.store.store.VO;

import com.store.store.entity.FoodClass;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class FoodClassList {
    Integer result;
    List<FoodClass> foodClasses;
}

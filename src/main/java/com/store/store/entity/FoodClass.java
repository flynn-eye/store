package com.store.store.entity;

import lombok.Data;

@Data
public class FoodClass {
    Integer classId;
    String className;
    Integer parentId;
    String parentName;
}

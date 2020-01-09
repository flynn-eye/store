package com.store.store.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class User {
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private Integer role;
    private String name;
    private Integer forbidden;
    private Integer del;

}

package com.store.store.cache;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Data
public class User implements Serializable {
    private String userName;
    private Integer userId;
    private String sessionId;
}

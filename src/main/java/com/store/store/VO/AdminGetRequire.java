package com.store.store.VO;

import lombok.Data;

@Data
public class AdminGetRequire {
    Integer requireId;
    String createTime;
    String itemInf;
    Integer userId;
    Integer status;
    String rejectReason;
    String userName;
    String windowNum;//名
    String name;//食堂名
}

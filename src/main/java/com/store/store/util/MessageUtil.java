package com.store.store.util;

import com.store.store.entity.User;
import com.zhenzi.sms.ZhenziSmsClient;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "105326", "e73e9f7c-1b9a-4738-a197-c5e8898488ac");
    public void sendLoginMsg(User user) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("message", "验证码为: "+user.getPassword());
        params.put("number", user.getPhone());
        String result = client.send(params);
        System.out.println(result);
    }
}

package com.store.store;

import com.store.store.cache.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;

import javax.rmi.CORBA.StubDelegate;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    User user;
    @Test
    void contextLoads() {

    }
    @Test
    void redisTestSet(){
        user.setUserId(1);
        user.setUserName("zy");
        user.setSessionId("2312");
        redisTemplate.opsForValue().set("robber",user);
    }
    @Test
    void redisTestGet(){
        System.out.println(redisTemplate.opsForValue().get("robber"));
    }
    @Test
    void redisDel(){
        redisTemplate.delete("robber");
    }
    @Test
    void redisString(){
        redisTemplate.opsForValue().set("str","hello world");
    }
    @Test
    void redisList(){
        ListOperations<String,String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("mylist","first");
        listOperations.rightPush("mylist","second");
        listOperations.leftPop("mylist");
        listOperations.rightPop("mylist");
        System.out.println(listOperations.range("mylist",0,1));//截取下标为0开始
    }
    @Test
    void redisSet(){
        SetOperations<String,String>setOperations = redisTemplate.opsForSet();
        setOperations.add("myset","hello");
        setOperations.add("myset","world");
        System.out.println(setOperations.members("myset"));
    }
    @Test
    void redisZSet(){
        ZSetOperations<String,String>zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("myzset","helloa",1);
        zSetOperations.add("myzset","hellob",2);
        zSetOperations.add("myzset","helloc",3);
        zSetOperations.add("myzset","hellod",0);
        System.out.println(zSetOperations.range("myzset",0,8));
        System.out.println(zSetOperations.zCard("myzset"));
    }
    @Test
    void redisHash(){
        HashOperations<String,String,String>hashOperations = redisTemplate.opsForHash();
        //hashOperations.put("myhash","name","zy");
        System.out.println(hashOperations.get("myhash","name"));
    }
    @Test
    void showDataBase(){
       LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
       lettuceConnectionFactory.setDatabase(13);
        System.out.println(lettuceConnectionFactory.getDatabase());
    }
}
